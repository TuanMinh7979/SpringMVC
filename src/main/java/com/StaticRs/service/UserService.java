package com.StaticRs.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.StaticRs.pojo.User;

public interface UserService extends UserDetailsService {
	boolean addUser(User user);

	List<User> getUsers(String username);
}
