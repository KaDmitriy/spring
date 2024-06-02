package kda.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Page {
	
	@Value("${nameapp}")
	private String nameApp; 

	
	@GetMapping("/")
	public String getMethodName() {
		return "index";
	}
	
	@GetMapping("/info.html")
	public String getInfo(Model model) {
		model.addAttribute("nameapp",  nameApp);
		model.addAttribute("javaversiontext",  Runtime.version().toString());
		model.addAttribute("javahome", System.getProperty("java.home"));
		return "info";
	}

}
