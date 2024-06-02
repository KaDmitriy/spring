package kda.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Page {

	
	@GetMapping("/")
	public String getMethodName() {
		return "index";
	}
	
	@GetMapping("/info.html")
	public String getInfo(Model model) {
		model.addAttribute("javaversiontext",  Runtime.version().toString());
		model.addAttribute("javahome", System.getProperty("java.home"));
		//model.addAttribute("javaversiontext",  "asdf");
		return "info";
	}

}
