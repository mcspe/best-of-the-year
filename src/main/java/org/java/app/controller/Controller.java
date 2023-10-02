package org.java.app.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@org.springframework.stereotype.Controller
public class Controller {
	
	@GetMapping("/")
	public String index(Model model) {
		final String name = "Marco";
		model.addAttribute("name", name);
		return "index";
	}

}
