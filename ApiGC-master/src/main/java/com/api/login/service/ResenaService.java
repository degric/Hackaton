package com.api.login.service;

import com.api.login.pojo.Resena;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ResenaService {
    ResponseEntity<String> register(Map<String, String> requestMap);

    ResponseEntity<String> update(Integer id, Map<String, String> requestMap);

    ResponseEntity<String> delete(Integer id);

    ResponseEntity<List<Resena>> getAllResena();

    //ResponseEntity<String> getById(Integer id);
}