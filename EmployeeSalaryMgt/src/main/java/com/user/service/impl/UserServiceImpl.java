package com.user.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.helper.UserFoundException;
import com.user.model.User;
import com.user.model.UserRole;
import com.user.repository.RoleRepository;
import com.user.repository.UserRepository;
import com.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	//creating user
	@Override
	public User creatUser(User user, Set<UserRole> userRoles) throws Exception {
		User local=this.userRepository.findByUsername(user.getUsername());
		if(local!=null) {
			System.out.println("user is already there!!");
			throw new UserFoundException();
		}
		else {
			for(UserRole ur:userRoles) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRole().addAll(userRoles);
			local=this.userRepository.save(user);
			
		}
		return local;
	}

	@Override
	public User getUser(String username) {
		
		return this.userRepository.findByUsername(username);
	}


	@Override
	public User update(String user, Set<UserRole> userRoles) {
		User user1 = this.userRepository.findByUsername(user);
		return user1;
	}

	@Override
	public void deleteUser(Long userId) {
		this.userRepository.deleteById(userId);
		
	}

	@Override
	public List<User> getAllUser() {
		List<User> findAll = this.userRepository.findAll();
		return findAll;
	}
	
}
