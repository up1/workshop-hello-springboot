package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello2Controller {

    @GetMapping("/hello/{name}")
    public HelloResponse sayHi(@PathVariable String name) {
        return new HelloResponse("Hello, " + name);
    }

}
// POJO object/class or Data class
class HelloResponse {
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
