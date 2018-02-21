package com.toxic.spring.udemy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InitialPageController {
	
	@RequestMapping("/")
	public String showForm() {
		
		return "main-menu";
	}

}
