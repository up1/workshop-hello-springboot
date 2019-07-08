package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Optional;

@RestController
public class Hello2Controller {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping("/hello/{name}")
    public HelloResponse sayHi(@PathVariable String name) {
        Optional<Employee> employee = repository.findByName(name);
        if(employee.isPresent()) {
            return new HelloResponse("Hello, " + employee.get().getName());
        }
        return new HelloResponse(name + " not found");
    }

}
// POJO object/class or Data class
class HelloResponse {

    @Override
    public String toString() {
        return "HelloResponse{" +
                "message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HelloResponse that = (HelloResponse) o;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }

    private String message;

    public HelloResponse() {
    }

    public HelloResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}
