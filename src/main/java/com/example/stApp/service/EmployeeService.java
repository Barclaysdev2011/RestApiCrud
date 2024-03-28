package com.example.stApp.service;

import com.example.stApp.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long id);

    List<EmployeeDto> getAllEmployee();
    EmployeeDto updateEmployee(Long id, EmployeeDto updateEmp);

    void deleteEmp(long id);
}
