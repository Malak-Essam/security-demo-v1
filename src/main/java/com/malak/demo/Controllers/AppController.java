package com.malak.demo.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AppController {
	@GetMapping("/public/hello")
	public String publicHello() {
		return "hello, public";
	}
	
	@GetMapping("/user/hello")
	public String userHello() {
		return "hello, user";
	}
	
	@GetMapping("/admin/hello")
	public String adminHello() {
		return "hello, admin";
	}
}
