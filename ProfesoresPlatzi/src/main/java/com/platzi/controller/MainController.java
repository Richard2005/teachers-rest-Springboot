package com.platzi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping("/")
	@ResponseBody
	public String index() {
		String response = "Bienvenido a <a href='http://Platzi.com'> platzi.com </a>";
		return response;
	}

}
