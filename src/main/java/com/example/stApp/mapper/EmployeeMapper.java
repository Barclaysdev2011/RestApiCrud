package com.example.stApp.mapper;

import com.example.stApp.dto.EmployeeDto;
import com.example.stApp.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmpoyeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }
    public static Employee mapToEmpoyee(EmployeeDto employee){
        return new Employee(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }
}
