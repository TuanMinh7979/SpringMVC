package com.StaticRs.repo;

import java.util.List;

import com.StaticRs.pojo.User;

public interface UserRepo {
	boolean addUser(User user);
    List<User> getUsers(String username);
    

}
