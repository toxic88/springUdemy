package com.toxic.spring.udemy;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@InitBinder
	public void initBinder(WebDataBinder datBinder) {
		StringTrimmerEditor trimmer = new StringTrimmerEditor(true);
		datBinder.registerCustomEditor(String.class, trimmer);
	}
	
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		theModel.addAttribute("customer", new Customer());
		return "customer-form";
	}
	
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult binding) {
		
		System.out.println("bind result : " + binding);
		
		System.out.println("\n\n\n");
		
		if (binding.hasErrors()) {
			return "customer-form";
		}
		return "customer-confirmation";
	}

}
