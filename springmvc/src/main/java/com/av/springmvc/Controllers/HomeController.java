package com.av.springmvc.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/hello")
	public String sayHello() {
		return "hello";
	}
}