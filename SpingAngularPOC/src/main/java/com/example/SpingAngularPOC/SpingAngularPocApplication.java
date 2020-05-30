package com.example.SpingAngularPOC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpingAngularPocApplication {

	/*@Bean
	public WebSecurityConfigurerAdapter webSecurityConfig() {
		return new WebSecurityConfigurerAdapter() {
			@Override
			protected void configure(HttpSecurity http) throws Exception {
				http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
						.anyRequest().authenticated().and().csrf().ignoringAntMatchers("/console/**").and().headers()
						.frameOptions().sameOrigin().and().httpBasic();
			}
		};
	}*/

	public static void main(String[] args) {
		SpringApplication.run(SpingAngularPocApplication.class, args);
	}

}
