package pl.szczerbiak.demoapp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldEndPoint {
    //localhost:8080/hello
    //helloworld

    @RequestMapping(method = /*ctrl + spacja*/ RequestMethod.GET, path/*ctrl+p - czym wypełnić*/ = "/hello")

    String hello(){
        return "Hello World :)" ;
    }
}
