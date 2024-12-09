package com.api.login.Documentos.MinutaDeReunion.Repository;

import com.api.login.Documentos.MinutaDeReunion.Pojo.MinuReunDatos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MinuReunDatosRepository extends JpaRepository<MinuReunDatos, Long> {
    List<MinuReunDatos> findByMinutaReunion_IdMinutaReunion(Long idMinutaReunion);
}

