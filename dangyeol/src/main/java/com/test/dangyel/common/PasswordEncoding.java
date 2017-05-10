package com.test.dangyel.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; 
import org.springframework.security.crypto.password.PasswordEncoder;


public class PasswordEncoding implements PasswordEncoder{

	private PasswordEncoder passwordencoder;
	
	public PasswordEncoding() {
		this.passwordencoder = new BCryptPasswordEncoder();
	}

	public PasswordEncoding(PasswordEncoder passwordencoder) {
		this.passwordencoder = passwordencoder;
	}
	


	@Override
	public String encode(CharSequence rawPassword) {
		return passwordencoder.encode(rawPassword);
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return passwordencoder.matches(rawPassword, encodedPassword);
	}
}
