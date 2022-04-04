package com.practice.restapi.exercise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.restapi.exercise.model.Employee;
import com.practice.restapi.exercise.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    
    @GetMapping({"/{id}"})
    public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employees) {
    	Employee employees1 = employeeService.insert(employees);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(employees1, httpHeaders, HttpStatus.CREATED);
    }
    
    @PutMapping({"/{id}"})
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employees) {
        employeeService.updateEmployee(id, employees);
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }
    
    @DeleteMapping({"/{id}"})
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Integer id) {
    	employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
