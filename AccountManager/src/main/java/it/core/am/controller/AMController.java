package it.core.am.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AMController 
{
	@RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
