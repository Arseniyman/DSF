package com.av.springmvc.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DoController {
	
	@GetMapping("/exit")
	public String exit() {
		return "morn/exit";
	}
}