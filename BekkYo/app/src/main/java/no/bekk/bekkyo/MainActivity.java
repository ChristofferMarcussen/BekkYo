package no.bekk.bekkyo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import no.bekk.bekkyo.adapter.EmployeeListAdapter;
import no.bekk.bekkyo.adapter.EmployeeListItemClickListener;
import no.bekk.bekkyo.dto.EmployeeDto;
import no.bekk.bekkyo.rest.EmployeeService;
import no.bekk.bekkyo.rest.StaticUrls;
import no.bekk.bekkyo.sms.SMSService;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements EmployeeListItemClickListener {

    private RecyclerView employeeList;
    private List<EmployeeDto> employees = new ArrayList<>();
    private EmployeeService employeeService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        employeeList = (RecyclerView) findViewById(R.id.employee_list);
        employeeList.setLayoutManager(new LinearLayoutManager(this));
        employeeList.setAdapter(new EmployeeListAdapter(this, employees, this));

        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(StaticUrls.BASE_URL)
                .build();
        employeeService = adapter.create(EmployeeService.class);
        getEmployees();
    }

    public void getEmployees() {
        String authToken = "Custom ZGQxODI2ZTgtZWNmMi00ZDdkLWFmYzYtNmZkY2Y0YTU1YTFhOmIyOGFmOTA2LWNiOWEtNDgzZC1iMzMyLTliODBhMzY1ZDZlNjphNGY0NzQyNi01YzNjLTQwMjctYjkzOC02MjI3YjQ1YzJiZTU=";
        employeeService.getEmployees(authToken, new Callback<List<EmployeeDto>>() {
            @Override
            public void success(List<EmployeeDto> employeeDtos, Response response) {
                employees.clear();
                employees.addAll(employeeDtos);
                employeeList.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e(MainActivity.this.getLocalClassName(), error.getLocalizedMessage());
            }
        });
    }

    @Override
    public void employeeClicked(EmployeeDto dto) {
        SMSService.sendYo(dto);
    }

    @Override
    public void saveEmployee(EmployeeDto dto) {
        SharedPreferences prefs = this.getSharedPreferences(
                "no.bekk.bekkyo", Context.MODE_PRIVATE);
        prefs.edit().putString("yofavourite", new Gson().toJson(dto)).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.yo_favourites:
                // YOLO
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
