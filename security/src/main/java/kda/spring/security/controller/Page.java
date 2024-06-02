package kda.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Page {

	@GetMapping("/")
	public String getIndex() {
		return "index";
	}
	
	@GetMapping("/info.html")
	public String getInfo(Model model) {
		//model.addAttribute("javaversion",  Runtime.version().toString());
		//model.addAttribute("javaversiontext",  "asdf");
		return "info";
	}
	
}
