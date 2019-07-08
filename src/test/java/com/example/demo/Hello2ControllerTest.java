package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class Hello2ControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void sayHi() {
        HelloResponse response = this.restTemplate.getForObject(
                "/hello/somkiat", HelloResponse.class);
        assertEquals("Hello, somkiat", response.getMessage());
    }


    @Test
    public void sayHi2() {
        HelloResponse expected = new HelloResponse("Hello, somkiat");

        HelloResponse response = this.restTemplate.getForObject(
                "/hello/somkiat", HelloResponse.class);

        assertEquals(expected, response);
    }
}