package com.waiyanhtet.security.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.waiyanhtet.security.service.AccessInfoService;

@Controller
@RequestMapping("admin")
public class AdminHomeController {

	@Autowired
	private AccessInfoService accessInfoService;
	
	@GetMapping("home")
	public void home(ModelMap model) {
		model.put("accessInfoList", accessInfoService.getAllAccessInfo());
	}
}
