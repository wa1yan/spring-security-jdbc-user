package com.waiyanhtet.security.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AccessInfoDto {

	private int id;
	private String loginId;
	private String userName;
	private LocalDateTime accessTime;
	private Type type;
	
	
	public enum Type {
		Login, Logout;
	}
}
