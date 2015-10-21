package no.bekk.bekkyo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import no.bekk.bekkyo.adapter.EmployeeListAdapter;
import no.bekk.bekkyo.adapter.EmployeeListItemClickListener;
import no.bekk.bekkyo.dto.EmployeeDto;


public class FavouritesActivity extends AppCompatActivity implements EmployeeListItemClickListener {

    private RecyclerView employeeList;
    private List storedEmployees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences prefs = this.getSharedPreferences(
                "no.bekk.bekkyo", Context.MODE_PRIVATE);
        Type type = new TypeToken<List<EmployeeDto>>(){}.getType();
        storedEmployees = new Gson().fromJson(prefs.getString("yofavourite", ""), type);

        employeeList = (RecyclerView) findViewById(R.id.employee_favourites_list);
        employeeList.setLayoutManager(new LinearLayoutManager(this));
        employeeList.setAdapter(new EmployeeListAdapter(this, storedEmployees, this));
    }

    @Override
    public void employeeClicked(EmployeeDto dto) {

    }
}
