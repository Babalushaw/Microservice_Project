package com.mindstux.userservice.service;

import com.mindstux.userservice.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public User saveUser(User user);
    public void deleteUser(String userId);
    public List<User> getAllUser();
    public User getUser(String userId);
}
