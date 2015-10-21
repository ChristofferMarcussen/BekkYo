package no.bekk.bekkyo.adapter;

import no.bekk.bekkyo.dto.EmployeeDto;

public interface EmployeeListItemClickListener {
    void employeeClicked(EmployeeDto dto);
    void saveEmployee(EmployeeDto dto);
}
