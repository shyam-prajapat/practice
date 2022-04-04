package com.practice.restapi.exercise.repository;

import org.springframework.data.repository.CrudRepository;

import com.practice.restapi.exercise.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
