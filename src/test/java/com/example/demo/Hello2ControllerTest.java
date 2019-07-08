package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class Hello2ControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Test
    public void sayHi() {
        Employee somkiat = new Employee();
        somkiat.setName("somkiat");
        given(employeeRepository.findByName("somkiat"))
                .willReturn(Optional.of(somkiat));

        HelloResponse response = this.restTemplate.getForObject(
                "/hello/somkiat", HelloResponse.class);
        assertEquals("Hello, somkiat", response.getMessage());
    }

    @Test
    public void sayHi_with_not_found() {
        given(employeeRepository.findByName("somkiat"))
                .willReturn(Optional.empty());

        HelloResponse response = this.restTemplate.getForObject(
                "/hello/somkiat", HelloResponse.class);
        assertEquals("somkiat not found", response.getMessage());
    }


    @Test
    public void sayHi2() {
        Employee somkiat = new Employee();
        somkiat.setName("somkiat");
        given(employeeRepository.findByName("somkiat"))
                .willReturn(Optional.of(somkiat));

        HelloResponse expected = new HelloResponse("Hello, somkiat");

        HelloResponse response = this.restTemplate.getForObject(
                "/hello/somkiat", HelloResponse.class);

        assertEquals(expected, response);
    }
}