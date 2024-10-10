package com.bach.qlkh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class QlkhApplication {

	public static void main(String[] args) {
		SpringApplication.run(QlkhApplication.class, args);

//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		String rawPassword = "admin";
//		String encodedPassword = encoder.encode(rawPassword);
//
//		System.out.println("Encoded password: " + encodedPassword);
	}

}
