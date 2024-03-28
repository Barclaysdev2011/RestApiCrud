package com.example.stApp.service.impl;

import com.example.stApp.dto.EmployeeDto;
import com.example.stApp.entity.Employee;
import com.example.stApp.exception.ResourceNotFound;
import com.example.stApp.mapper.EmployeeMapper;
import com.example.stApp.repository.EmployeeRepo;
import com.example.stApp.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepo employeeRepo;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmpoyee(employeeDto);
       Employee saveEmployee =  employeeRepo.save(employee);

        return EmployeeMapper.mapToEmpoyeeDto(saveEmployee);
    }


    @Override
    public EmployeeDto getEmployeeById(Long id) {
   Employee employee=  employeeRepo.findById(id)
            .orElseThrow(()->
                    new ResourceNotFound(("Employee is not exist " + id)));
        return EmployeeMapper.mapToEmpoyeeDto((employee));
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees = employeeRepo.findAll();
        return employees.stream().map((emp)->EmployeeMapper.mapToEmpoyeeDto(emp))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto updateEmp) {
       Employee emp =  employeeRepo.findById(id).orElseThrow(
                ()->new ResourceNotFound("Employee not found")
        );

       emp.setFirstName(updateEmp.getFirstName());
       emp.setLastName(updateEmp.getLastName());
       emp.setEmail(updateEmp.getEmail());

      Employee updatedEmp =  employeeRepo.save(emp);
        return EmployeeMapper.mapToEmpoyeeDto(updatedEmp) ;
    }

    @Override
    public void deleteEmp(long id) {
        Employee emp =  employeeRepo.findById(id).orElseThrow(
                ()->new ResourceNotFound("Employee not found")
        );

        employeeRepo.deleteById(id);
    }


}
