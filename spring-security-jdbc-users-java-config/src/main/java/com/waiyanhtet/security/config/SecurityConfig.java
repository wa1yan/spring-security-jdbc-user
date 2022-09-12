package com.waiyanhtet.security.config;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SuppressWarnings("deprecation")
@EnableWebSecurity
@ComponentScan(basePackages = {"com.waiyanhtet.security.service","com.waiyanhtet.security.listener"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	DataSource dataSource() {
		var datasource = new BasicDataSource();
		datasource.setUrl("jdbc:mysql://localhost:3306/testdbforspringsecurity");
		datasource.setUsername("root");
		datasource.setPassword("root");
		return datasource;
	}

	@Bean
	SimpleJdbcInsert userInsert(DataSource dataSource) {
		var userInsert = new SimpleJdbcInsert(dataSource);
		userInsert.setCatalogName("testdbforspringsecurity");
		userInsert.setTableName("user");
		userInsert.setColumnNames(List.of("loginId", "password", "name"));
		return userInsert;
	}
	
	@Bean
	SimpleJdbcInsert accessInfoInsert(DataSource dataSource) {
		var userInsert = new SimpleJdbcInsert(dataSource);
		userInsert.setCatalogName("testdbforspringsecurity");
		userInsert.setTableName("accessInfo");
		userInsert.setColumnNames(List.of("login_id","type"));
		return userInsert;
	}

	@Bean
	BCryptPasswordEncoder bcryptEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.inMemoryAuthentication()
		.withUser("admin")
		.authorities("Admin")
		.password(bcryptEncoder().encode("password"));


		auth.jdbcAuthentication()
				.dataSource(dataSource())
				.passwordEncoder(bcryptEncoder())
				.usersByUsernameQuery("select loginId,password,valid from user where loginId = ?")
				.authoritiesByUsernameQuery("select loginId, role from user where loginId = ?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		http.authorizeRequests().antMatchers("/admin/**").hasAuthority("Admin");
		http.authorizeRequests().antMatchers("/member/**").hasAnyAuthority("Member", "Admin");

		http.formLogin().loginPage("/login").loginProcessingUrl("/login").usernameParameter("loginId")
				.passwordParameter("password");

		http.logout().logoutSuccessUrl("/").invalidateHttpSession(true);
	}
	
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	
}
