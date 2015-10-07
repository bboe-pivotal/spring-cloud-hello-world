package io.pivotal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

	@Value("${greeting}")
	String greeting;
	
	@RequestMapping("/hello")
    public String sayHello(@RequestParam(value="name", defaultValue="World") String toWho) {
		return String.format(greeting, toWho);
	}
	
}
