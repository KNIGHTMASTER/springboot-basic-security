package com.zisal.security.springbootbasicsecurity;

import com.zisal.security.springbootbasicsecurity.entity.User;
import com.zisal.security.springbootbasicsecurity.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class SpringbootBasicSecurityApplication {

	@Autowired
	private IUserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBasicSecurityApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner() {
		return args -> {
			List<User> users = userService.findAll();
			for (User user : users) {
				if (user.getHashed() != 1) {
					user.setPassword(passwordEncoder.encode(user.getPassword()));
					user.setHashed(1);
					userService.update(user);
				}
			}
		};
	}
}
