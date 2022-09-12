package com.waiyanhtet.security.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import com.waiyanhtet.security.model.AccessInfoDto;
import com.waiyanhtet.security.model.AccessInfoDto.Type;

@Service
public class AccessInfoService {

	@Autowired
	private SimpleJdbcInsert accessInfoInsert;
	
	private RowMapper<AccessInfoDto> rowMapper;
	
	public AccessInfoService() {
		rowMapper = new BeanPropertyRowMapper<>(AccessInfoDto.class);
	}

	public void create(String username, Type type) {
		accessInfoInsert.execute(Map.of(
				"login_id",username,
				"type",type.name()));
	}
	
	public List<AccessInfoDto> getAllAccessInfo() {
		return accessInfoInsert.getJdbcTemplate()
				.query("select a.id, a.login_id, u.name userName, a.type, a.access_time from accessInfo a join user u on a.login_id = u.loginId order by a.access_time desc",
						rowMapper);
	}

	public List<AccessInfoDto> getAccessInfo(String username) {
		return accessInfoInsert.getJdbcTemplate()
				.query("select a.id, a.login_id, u.name userName, a.type, a.access_time from accessInfo a join user u on a.login_id = u.loginId and u.loginId = ? order by a.access_time desc",
						stmt -> stmt.setString(1, username),
						rowMapper);
	}
}
