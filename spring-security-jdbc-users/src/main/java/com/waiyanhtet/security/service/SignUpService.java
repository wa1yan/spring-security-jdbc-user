package com.waiyanhtet.security.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.waiyanhtet.security.model.SignUpDto;

@Service
public class SignUpService {

	@Autowired
	private SimpleJdbcInsert userInsert;
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	
	@Autowired
	private AuthenticationManager authManager;
	
	public Authentication signUp(SignUpDto dto) {
		//save to database
		Map<String, Object> params = new HashMap<>();	
		params.put("loginId", dto.getLoginId());
		params.put("password", bcryptEncoder.encode(dto.getPassword()));
		params.put("name", dto.getName());
		
		var result = userInsert.execute(params);

		//programmatic login
		if(result == 1) {
			var token = new UsernamePasswordAuthenticationToken(dto.getLoginId(), dto.getPassword());
			return authManager.authenticate(token);
		}
		return null;
	}
}
