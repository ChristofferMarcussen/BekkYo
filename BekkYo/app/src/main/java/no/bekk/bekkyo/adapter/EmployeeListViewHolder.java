package no.bekk.bekkyo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import no.bekk.bekkyo.R;
import no.bekk.bekkyo.dto.EmployeeDto;
import no.bekk.bekkyo.rest.StaticUrls;

public class EmployeeListViewHolder extends RecyclerView.ViewHolder {
    TextView employeeNameView;
    ImageView employeeImageView;
    Button yoButton;

    public EmployeeListViewHolder(View itemView) {
        super(itemView);

        employeeNameView = (TextView) itemView.findViewById(R.id.employee_name_view);
        employeeImageView = (ImageView) itemView.findViewById(R.id.employee_image_view);
        yoButton = (Button) itemView.findViewById(R.id.yo_button);
    }

    public void bindData(EmployeeDto employeeDto) {
        employeeNameView.setText(employeeDto.getName());
        Picasso.with(itemView.getContext())
                .load(StaticUrls.IMAGE_URL + "employee=" + employeeDto.getId())
                .into(employeeImageView);
    }
}
