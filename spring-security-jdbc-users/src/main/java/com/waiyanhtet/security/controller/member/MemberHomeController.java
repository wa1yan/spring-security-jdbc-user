package com.waiyanhtet.security.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member")
public class MemberHomeController {

	@GetMapping("home")
	public void home() {
	}
}
