package com.practice.restapi.exercise.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.restapi.exercise.model.Employee;
import com.practice.restapi.exercise.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    
    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }
    
    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).get();
    }
    
    @Override
    public Employee insert(Employee employees) {
        return employeeRepository.save(employees);
    }
    
    
    @Override
    public void updateEmployee(Integer id, Employee employee) {
    	Employee employeesFromDb = employeeRepository.findById(id).get();
    	employeesFromDb.setName(employee.getName());
    	employeesFromDb.setEmail(employee.getEmail());
    	employeesFromDb.setPhone(employee.getPhone());
    	employeesFromDb.setAddress(employee.getAddress());
        employeeRepository.save(employeesFromDb);
    }
    
    
    @Override
    public void deleteEmployee(Integer id) {
    	employeeRepository.deleteById(id);
    }
    
}
