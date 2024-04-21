package com.bca.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping(path = "hello")
    public String hello()
    {
        return "Hello";
    }
//    @GetMapping(path = "/hello/{name}/{city}")
//    public ResponseEntity<Object> getNameAndCity(@PathVariable(name = "name") String name,@PathVariable(name = "city")String city)
//    {
//        String return1="Hello "+name+" from "+city;
//        return  ResponseEntity.accepted().body(return1);
//    }
@GetMapping(path = "hello1/{name}/{city}")
public String getNameAndCityUsingPathVariable(@PathVariable(name = "name") String name,@PathVariable(name = "city")String city)
{
    System.out.println("here");
    String return1="Hello "+name+" from "+city;
    return  return1;
}
    @GetMapping(path = "hello2")
    public String getNameAndCityUsingRequestParam(@RequestParam(name = "name") String name, @RequestParam(name = "city")String city)
    {
        System.out.println("here");
        String return1="Hello "+name+" from "+city;
        return  return1;
    }
}
