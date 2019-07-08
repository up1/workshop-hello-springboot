package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void found_from_get_data_by_name() {
        // Create new employee
        Employee e1 = new Employee();
        e1.setName("somkiat");
        employeeRepository.save(e1);

        // Find by name
        Optional<Employee> result
                = employeeRepository.findByName("somkiat");

        // Check result
        assertTrue(result.isPresent());

        assertEquals(1, employeeRepository.count());
    }

    @Test
    public void not_found_from_get_data_by_name() {
        // Create new employee
        Employee e1 = new Employee();
        e1.setName("somkiat");
        employeeRepository.save(e1);

        // Find by name
        Optional<Employee> result
                = employeeRepository.findByName("somkiat 2");

        // Check result
        assertFalse(result.isPresent());
        assertEquals(1, employeeRepository.count());
    }

}