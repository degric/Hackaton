package com.api.login.service.impl;

import com.api.login.constantes.UsuarioConstantes;
import com.api.login.dao.PuestoDao;
import com.api.login.pojo.Departamento;
import com.api.login.pojo.Puesto;
import com.api.login.security.jwt.JwtFilter;
import com.api.login.security.jwt.JwtUtil;
import com.api.login.service.PuestoService;
import com.api.login.util.ResenaUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
public class PuestoServiceImpl implements PuestoService {

    @Autowired
    private PuestoDao puestoDao;

    @Autowired
    private JwtFilter jwtFilter;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public ResponseEntity<String> register(Map<String, String> requestMap) {
        log.info("Registro interno de una empresa {}", requestMap);
        try {
            if (validateRegister(requestMap)){
                puestoDao.save(getPuestoFromMap(requestMap));
                return ResenaUtil.getResponseEntity1("Empresa registrada con exito", HttpStatus.CREATED);
            }else {
                return ResenaUtil.getResponseEntity1(UsuarioConstantes.INVALID_DATA, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return ResenaUtil.getResponseEntity1(UsuarioConstantes.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> update(Integer id,Map<String, String> requestMap ) {
        try {
            // Obtén el ID del usuario de la solicitud y trata de encontrarlo en la base de datos
            Optional<Puesto> optionalUser = puestoDao.findById(id);

            if (!optionalUser.isEmpty()) {
                // Obtén el usuario de la base de datos
                Puesto puesto = optionalUser.get();

                // Actualiza los campos del usuario con los valores proporcionados en el mapa

                puesto.setNamePosition(requestMap.get("namePosition"));
                puesto.setDeparmentPosition(requestMap.get("deparmentPosition"));
                puesto.setFuntionsPosition(requestMap.get("funtionsPosition"));


                // Actualiza el usuario en la base de datos
                puestoDao.save(puesto);

                // Retorna una respuesta con un mensaje exitoso y el código de estado 200 (OK)
                return ResenaUtil.getResponseEntity1("Datos del usuario actualizados", HttpStatus.OK);
            } else {
                // Retorna una respuesta con un mensaje indicando que el usuario no existe y el código de estado 404 (Not Found)
                return ResenaUtil.getResponseEntity1("Este usuario no existe", HttpStatus.NOT_FOUND);
            }
        } catch (Exception exception) {
            // Imprime la traza de la excepción en caso de un error inesperado
            exception.printStackTrace();
        }

        // Retorna una respuesta con un mensaje de error genérico y el código de estado 500 (Internal Server Error)
        return ResenaUtil.getResponseEntity1(UsuarioConstantes.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> delete(Integer Id) {
        try {
            // Trata de encontrar al usuario en la base de datos utilizando el ID proporcionado
            Optional<Puesto> optionalUser = puestoDao.findById(Id);

            if (optionalUser.isPresent()) {
                // Elimina al usuario de la base de datos
                puestoDao.deleteById(Id);

                // Retorna una respuesta con un mensaje exitoso y el código de estado 200 (OK)
                return ResenaUtil.getResponseEntity1("Resena eliminada exitosamente", HttpStatus.OK);
            } else {
                // Retorna una respuesta con un mensaje indicando que el usuario no existe y el código de estado 404 (Not Found)
                return ResenaUtil.getResponseEntity1("Esta resena no existe", HttpStatus.NOT_FOUND);
            }
        } catch (Exception exception) {
            // Imprime la traza de la excepción en caso de un error inesperado
            exception.printStackTrace();
        }

        // Retorna una respuesta con un mensaje de error genérico y el código de estado 500 (Internal Server Error)
        return ResenaUtil.getResponseEntity1(UsuarioConstantes.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<Puesto>> getAllPuesto() {
        try{
            return new ResponseEntity<>(puestoDao.getAllPuesto(),HttpStatus.OK);
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    private boolean validateRegister(Map<String,String> requestMap){
        if (requestMap.containsKey("namePosition") &&
                requestMap.containsKey("deparmentPosition") &&
                requestMap.containsKey("funtionsPosition")){
            return true;
        }
        return false;
    }

    private Puesto getPuestoFromMap(Map<String, String> requestMap){
        Puesto puesto = new Puesto();
        puesto.setNamePosition(requestMap.get("namePosition"));
        puesto.setDeparmentPosition(requestMap.get("deparmentPosition"));
        puesto.setFuntionsPosition(requestMap.get("funtionsPosition"));
        return puesto;
    }

    private void insertar(Map<String,String> requestMap){
        try {
            Puesto puesto = new Puesto();
            puesto.setNamePosition((String) requestMap.get("namePosition"));
            puesto.setDeparmentPosition((String) requestMap.get("deparmentPosition"));
            puesto.setFuntionsPosition((String) requestMap.get("funtionsPosition"));

        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
