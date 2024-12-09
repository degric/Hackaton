package com.api.login.rest;

import com.api.login.constantes.UsuarioConstantes;
import com.api.login.pojo.User;
import com.api.login.service.UserService;
import com.api.login.util.UsuarioUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> registrarUsuario(@RequestBody(required = true)Map<String, String> requestMap){
        try{
            return userService.signUp(requestMap);
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return UsuarioUtil.getResponseEntity(UsuarioConstantes.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody(required = true) Map<String,String> requestmap){
        try {
            return userService.login(requestmap);
        }catch (Exception e){
            e.printStackTrace();
        }
        return UsuarioUtil.getResponseEntity(UsuarioConstantes.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/get")
    public ResponseEntity<List<User>> listarUsuarios(){
        try {
            return userService.getAllUsers();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return new ResponseEntity<List<User>>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @PutMapping("/update")
    public ResponseEntity<String> actualizarUsuario(@RequestBody(required = true) Map<String,String> requestmap){
        try {
            return userService.update(requestmap);
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return UsuarioUtil.getResponseEntity(UsuarioConstantes.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
