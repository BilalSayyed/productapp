package com.bca.controller;

import com.bca.config.DbConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@PropertySources(PropertySources={classpath:/ap})
@RestController
public class HelloController {
//    @Value("${my.key:value is not found}")
//    private String key;
//    @Value("${my.key2:value is not found}")
//    private String key2;
    @Autowired
    private Environment environment;
//    private String key=environment.getProperty("my.key");
//    private String key2=environment.getProperty("my.key2");

    @Autowired
   private DbConfig dbConfig;
    @GetMapping(path = "hello")
    public String hello()
    {
        System.out.println("in hello");
//        System.out.println(key);
        System.out.println(dbConfig.toString());
        System.out.println(environment.getProperty("my.key"));
        System.out.println(environment.getProperty("my.key2"));
        return "Hello ";
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
