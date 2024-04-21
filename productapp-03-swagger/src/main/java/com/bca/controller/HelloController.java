package com.bca.controller;

import com.bca.config.DbConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private Environment environment;
    @Autowired
    private DbConfig dbConfig;

    public HelloController() {
    }

    @GetMapping(
            path = {"hello"}
    )
    public String hello() {
        System.out.println("in hello");
        System.out.println(this.dbConfig.toString());
        System.out.println(this.environment.getProperty("my.key"));
        System.out.println(this.environment.getProperty("my.key2"));
        return "Hello ";
    }

    @GetMapping(
            path = {"hello1/{name}/{city}"}
    )
    public String getNameAndCityUsingPathVariable(@PathVariable(name = "name") String name, @PathVariable(name = "city") String city) {
        System.out.println("here");
        String return1 = "Hello " + name + " from " + city;
        return return1;
    }

    @GetMapping(
            path = {"hello2"}
    )
    public String getNameAndCityUsingRequestParam(@RequestParam(name = "name") String name, @RequestParam(name = "city") String city) {
        System.out.println("here");
        String return1 = "Hello " + name + " from " + city;
        return return1;
    }
}
