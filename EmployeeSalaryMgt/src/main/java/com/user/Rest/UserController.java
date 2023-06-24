package com.user.Rest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.helper.UserFoundException;
import com.user.model.Role;
import com.user.model.User;
import com.user.model.UserRole;
import com.user.repository.UserRepository;
import com.user.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception  {
		user.setProfile("abv.png");
		// encoding password
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		Set<UserRole> roles=new HashSet<>();
		
		Role role=new Role();
		role.setRoleId(44L);
		role.setRoleName("EMPLOYEE");
		
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		
		roles.add(userRole);		
		return this.userService.creatUser(user,roles);
		
	}
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return userService.getUser(username);
		
	}
	
	@GetMapping("alluser")
	public List<User> getAllUser() {
		return (List<User>) userService.getAllUser();
		
	}
	
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") Long userId) {
		this.userService.deleteUser(userId);
	}
	
	//Update user
	@PostMapping("/{username}")
	public User update(@PathVariable("username") String username,@PathVariable("userRole") Set<UserRole> userRoles) {
		return this.userService.update(username, userRoles);
		
	}
	
	@ExceptionHandler(UserFoundException.class)
	public ResponseEntity<?> exceptionHandler(UserFoundException e){
		return exceptionHandler(e);
	}
	
}
