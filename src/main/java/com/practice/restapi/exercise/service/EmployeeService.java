package com.practice.restapi.exercise.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.practice.restapi.exercise.model.Employee;

@Service
public interface EmployeeService {

	List<Employee> getEmployees();

	Employee getEmployeeById(Integer id);

    Employee insert(Employee employees);

    void updateEmployee(Integer id, Employee employees);

    void deleteEmployee(Integer id);
}
