package com.waiyanhtet.security.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.waiyanhtet.security.model.AccessInfoDto.Type;
import com.waiyanhtet.security.service.AccessInfoService;

@Component
public class LoginSuccessListener implements ApplicationListener<InteractiveAuthenticationSuccessEvent>  {

	@Autowired
	private AccessInfoService accessInfoService;
	
	@Override
	public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event) {
		if(event.getAuthentication().getPrincipal() instanceof User user) {
			if(!"admin".equals(user.getUsername())) {
				accessInfoService.create(user.getUsername(), Type.Login);
			}
			
		}
		
	}

}
