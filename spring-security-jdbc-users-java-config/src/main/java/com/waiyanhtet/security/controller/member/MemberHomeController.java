package com.waiyanhtet.security.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.waiyanhtet.security.service.AccessInfoService;

@Controller
@RequestMapping("member")
public class MemberHomeController {

	@Autowired
	private AccessInfoService accessInfoService;
	
	@GetMapping("home")
	public void home(ModelMap model) {
		var username = SecurityContextHolder.getContext().getAuthentication().getName();
		model.put("accessInfoList", accessInfoService.getAccessInfo(username));
	}
}
