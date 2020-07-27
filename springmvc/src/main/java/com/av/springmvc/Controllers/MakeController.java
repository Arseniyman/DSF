package com.av.springmvc.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class MakeController {
	
	@GetMapping("/say")
	public String helloPage(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "surname", required = false) String surname,
			Model model) {

		model.addAttribute("message", "Hello " + name + " " + surname);
		return "say/hello";
	}
	
	@GetMapping("/gp")
	public String goodPage() {
		return "say/good";
	}
}