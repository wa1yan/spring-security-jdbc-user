package com.waiyanhtet.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.waiyanhtet.security.model.SignUpDto;
import com.waiyanhtet.security.service.SignUpService;

@Controller
@RequestMapping("/signup")
public class SecurityController {

	@Autowired
	private SignUpService service;
	
	@GetMapping
	public String index() {
		return "security/signup";
	}

	@PostMapping
	public String signup(@Validated @ModelAttribute SignUpDto signUpDto, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "security/signup";
		}
		System.out.println(signUpDto);
		var authentication = service.signUp(signUpDto);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return "redirect:/member/home";
	}
	
	@ModelAttribute("signUpDto")
	SignUpDto dto() {
		return new SignUpDto();
	}
}
