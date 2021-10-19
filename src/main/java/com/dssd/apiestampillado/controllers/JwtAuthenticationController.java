package com.dssd.apiestampillado.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.dssd.apiestampillado.config.JwtTokenUtil;
import com.dssd.apiestampillado.iservices.IEscribanoService;
import com.dssd.apiestampillado.requests.JwtRequest;
import com.dssd.apiestampillado.requests.JwtResponse;
import com.dssd.apiestampillado.services.JwtUserDetailsService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private IEscribanoService escribanoService;

	@PostMapping("authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	private void authenticate(String username, String password) throws Exception {
	try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	} catch (DisabledException e) {
		throw new Exception("USER_DISABLED", e);
	} catch (BadCredentialsException e) {
		throw new Exception("INVALID_CREDENTIALS", e);
	}
}
	
//	@PostMapping("authenticate")
//	public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) {
//		int strength = 9;
//		Escribano escribano = escribanoService.findByEmail(authenticationRequest.getEmail());
//		if (escribano != null) {
//			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(strength, new SecureRandom());
//			if (encoder.matches(authenticationRequest.getPassword(), escribano.getPassword())) {
//				return ResponseEntity.ok(new JwtResponse(jwtTokenUtil.generateToken(escribano)));
//			} else {
//				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//			}
//		} else {
//			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//		}
//	}

	public IEscribanoService getEscribanoService() {
		return escribanoService;
	}

	public void setEscribanoService(IEscribanoService escribanoService) {
		this.escribanoService = escribanoService;
	}

	public JwtTokenUtil getJwtTokenUtil() {
		return jwtTokenUtil;
	}

	public void setJwtTokenUtil(JwtTokenUtil jwtTokenUtil) {
		this.jwtTokenUtil = jwtTokenUtil;
	}

	public JwtUserDetailsService getUserDetailsService() {
		return userDetailsService;
	}

	public void setUserDetailsService(JwtUserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}

	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
}
