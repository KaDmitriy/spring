package kda.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Page {

	
	@GetMapping("/")
	public String getMethodName() {
		return "index";
	}

}
