package com.example.stApp.repository;

import com.example.stApp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
}
