package com.api.login.service;

import com.api.login.pojo.User;
import org.springframework.http.ResponseEntity;


import java.util.Map;
import java.util.List;


public interface UserService {
    ResponseEntity<String> signUp(Map<String,String> requestMap);

    ResponseEntity<String> login(Map<String,String> requestMap);

    ResponseEntity<List<User>> getAllUsers();

    ResponseEntity<String> update(Map<String,String> requestMap);
}
