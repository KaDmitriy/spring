package kda.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Page {

	@GetMapping("/")
	public String getMethodName() {
		return "index";
	}
	
}