package com.ajay.security.api.tenant.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.model.AuthRequest;
import com.ajay.security.api.tenant.util.JwtUtil;

@RestController
@RequestMapping("/rest/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class HomeController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@RequestMapping("/ok")
	public String test() {
		return "OK";
	}

	@PostMapping("/authenticate")
	public ApiResponse generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch (Exception e) {
			throw new Exception("invalid username/password");
		}

		return new ApiResponse(LocalDateTime.now(), 200, null, "SUCCESS",
				jwtUtil.generateToken(authRequest.getUsername()));

	}
}
