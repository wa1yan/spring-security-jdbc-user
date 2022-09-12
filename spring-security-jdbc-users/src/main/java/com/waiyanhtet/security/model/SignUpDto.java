package com.waiyanhtet.security.model;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class SignUpDto {

	@NotBlank(message = "Username must not be empty")
	private String name;
	
	@NotBlank(message = "LoginId must not be empty")
	private String loginId;
	
	@NotBlank(message = "Password must not be empty")
	private String password;	
	
}
