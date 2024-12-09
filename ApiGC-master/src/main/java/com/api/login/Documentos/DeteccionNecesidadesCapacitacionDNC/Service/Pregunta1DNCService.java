package com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Service;

import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.DTO.Pregunta1DNCDTO;

import java.util.List;

public interface Pregunta1DNCService {

    List<Pregunta1DNCDTO> findAll();

    Pregunta1DNCDTO findById(Long id);

    List<Pregunta1DNCDTO> findByDetecionNeCaDNC(Long idDetecionNeCaDNC);

    Pregunta1DNCDTO save(Pregunta1DNCDTO pregunta1DNCDTO);

    Pregunta1DNCDTO update(Long id, Pregunta1DNCDTO pregunta1DNCDTO);

    void deleteById(Long id);
}
