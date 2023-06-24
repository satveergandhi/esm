package com.user.service;

import java.util.List;
import java.util.Set;

import com.user.model.User;
import com.user.model.UserRole;

public interface UserService {

	//create user 
	public User creatUser(User user,Set<UserRole> userRoles) throws Exception;
    
	//get user by name
	public User getUser(String username);
	
	//delete by id
	public void deleteUser(Long userId);
	
	//update user
	public User update(String user,Set<UserRole> userRoles);
	
	//get AllUser
	public List<User> getAllUser();
}
