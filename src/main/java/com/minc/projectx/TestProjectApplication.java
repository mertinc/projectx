package com.minc.projectx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@SpringBootApplication
public class TestProjectApplication extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(TestProjectApplication.class, args);
	}
	@Bean
	PasswordEncoder bcryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser("user1").password(encoder.encode("user")).roles("USER")
		.and()
		.withUser("admin1").password(encoder.encode("admin")).roles("ADMIN");
		}

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/home").permitAll()
				.antMatchers("/admin").hasAnyRole("ADMIN")
		.anyRequest().authenticated().and().httpBasic();

	}

}
