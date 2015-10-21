package no.bekk.bekkyo.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;
import java.util.List;

import no.bekk.bekkyo.MainActivity;
import no.bekk.bekkyo.R;
import no.bekk.bekkyo.dto.EmployeeDto;

public class EmployeeListAdapter extends RecyclerView.Adapter<EmployeeListViewHolder> {
    private final Context context;
    private final List<EmployeeDto> employeeList;
    private EmployeeListItemClickListener listener;

    public EmployeeListAdapter(Context context, List<EmployeeDto> employeeList,
                               EmployeeListItemClickListener listener) {
        this.context = context;
        this.employeeList = employeeList;
        this.listener = listener;
    }

    @Override
    public EmployeeListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.employee_list_item, parent, false);
        final EmployeeListViewHolder viewHolder = new EmployeeListViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Lagre som favoritt?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                listener.saveEmployee(employeeList.get(viewHolder.getAdapterPosition()));
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
            }
        });
        viewHolder.yoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.employeeClicked(employeeList.get(viewHolder.getAdapterPosition()));
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(EmployeeListViewHolder holder, int position) {
        holder.bindData(employeeList.get(position));
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

}
