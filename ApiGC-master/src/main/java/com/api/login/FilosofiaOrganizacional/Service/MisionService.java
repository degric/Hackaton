package com.api.login.FilosofiaOrganizacional.Service;

import com.api.login.FilosofiaOrganizacional.pojo.Mision;

import java.util.List;
import java.time.LocalDate;

public interface MisionService {

    List<Mision> findAll();

    Mision findById(Integer id);

    Mision save(Mision mision);

    Mision update(Integer id, Mision mision);

    void deleteById(Integer id);

    List<Mision> findByFecha(LocalDate fecha);
}

