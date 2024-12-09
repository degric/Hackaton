package com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Service;


import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.DTO.Preguntas2DNCDTO;

import java.util.List;

public interface Preguntas2DNCService {

    List<Preguntas2DNCDTO> findAll();

    Preguntas2DNCDTO findById(Long id);

    List<Preguntas2DNCDTO> findByDetecionNeCaDNC(Long idDetecionNeCaDNC);

    Preguntas2DNCDTO save(Preguntas2DNCDTO preguntas2DNCDTO);

    Preguntas2DNCDTO update(Long id, Preguntas2DNCDTO preguntas2DNCDTO);

    void deleteById(Long id);
}
