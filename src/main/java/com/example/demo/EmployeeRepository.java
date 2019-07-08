package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmployeeRepository
        extends CrudRepository<Employee, Integer> {

    Optional<Employee> findByName(String name);
}
