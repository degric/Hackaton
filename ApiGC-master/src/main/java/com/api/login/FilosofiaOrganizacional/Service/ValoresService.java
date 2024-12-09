package com.api.login.FilosofiaOrganizacional.Service;

import com.api.login.FilosofiaOrganizacional.pojo.Valores;

import java.util.List;
import java.time.LocalDate;

public interface ValoresService {

    List<Valores> findAll();

    Valores findById(Integer id);

    Valores save(Valores valores);

    Valores update(Integer id, Valores valores);

    void deleteById(Integer id);

    List<Valores> findByFecha(LocalDate fecha);
}

