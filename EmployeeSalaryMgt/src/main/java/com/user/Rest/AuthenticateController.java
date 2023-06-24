package com.user.Rest;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.config.JwtUtils;
import com.user.helper.UserNotFoundException;
import com.user.model.JwtRequest;
import com.user.model.User;
import com.user.model.jwtResponse;
import com.user.service.impl.UserDetailsServiceImpl;

@RestController
@CrossOrigin("*")
@EnableWebSecurity
public class AuthenticateController {
 
	 @Autowired
	private AuthenticationManager authenticationManager;
	
	 @Autowired
	 private UserDetailsServiceImpl userDetailsService;
	 
	 @Autowired
	 private JwtUtils jwtUtils;
	 
	 //generate token
	 @PostMapping("/generate-token")
	 public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		 try {
			 authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
		 }catch (UserNotFoundException e) {
			e.printStackTrace();
			throw new Exception("User Not found!!");
		}
		 //authenticate
		 UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
		 String token = this.jwtUtils.generateToken(userDetails);
		 return ResponseEntity.ok(new jwtResponse(token));
		 
	 }
	 
	private void authenticate(String username,String password) throws Exception {
		try{
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}catch (DisabledException e) {
			throw new Exception("User Disabled"+ e.getMessage());
		}catch (BadCredentialsException e) {
			throw new Exception("Invalid credentials"+e.getMessage());
		}
	}
	
	//return the details current User
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal) {
		return ((User) this.userDetailsService.loadUserByUsername(principal.getName()));
	}
}
