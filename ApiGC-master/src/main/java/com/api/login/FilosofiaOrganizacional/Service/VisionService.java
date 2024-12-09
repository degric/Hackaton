package com.api.login.FilosofiaOrganizacional.Service;

import com.api.login.FilosofiaOrganizacional.pojo.Vision;

import java.time.LocalDate;
import java.util.List;

public interface VisionService {

    List<Vision> findAll();

    Vision findById(Integer id);

    Vision save(Vision vision);

    Vision update(Integer id, Vision vision);

    void deleteById(Integer id);

    List<Vision> findByFecha(LocalDate fecha);
}

