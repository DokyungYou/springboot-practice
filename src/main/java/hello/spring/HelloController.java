package hello.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // /spring/hello-spring
    @GetMapping("/hello-spring")
    public String hello(){
        System.out.println("HelloController.hello");
        return "Hello spring";
    }
}
