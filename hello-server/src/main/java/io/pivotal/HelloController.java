package io.pivotal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bboe on 10/9/15.
 */
@RestController
public class HelloController {
    @Value("${greeting}")
    String greeting;

    @RequestMapping("/hello")
    public String sayHello(@RequestParam(value="name", defaultValue="World") String toWho) {
        return String.format("%s %s!", greeting, toWho);
    }
}
