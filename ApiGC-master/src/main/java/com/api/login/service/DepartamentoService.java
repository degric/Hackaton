package com.api.login.service;

import com.api.login.pojo.Departamento;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DepartamentoService {

    ResponseEntity<String> register(Map<String, String> requestMap);

    ResponseEntity<String> update(Integer id, Map<String, String> requestMap);

    ResponseEntity<String> delete(Integer id);

    ResponseEntity<List<Departamento>> getAllDepartamento();
}
