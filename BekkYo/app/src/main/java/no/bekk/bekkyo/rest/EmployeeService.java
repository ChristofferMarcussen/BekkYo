package no.bekk.bekkyo.rest;

import java.util.List;

import no.bekk.bekkyo.dto.EmployeeDto;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Header;

public interface EmployeeService {
    @GET("/employees")
    void getEmployees(@Header("Authorization") String authHeader,
                      Callback<List<EmployeeDto>> employees);
}
