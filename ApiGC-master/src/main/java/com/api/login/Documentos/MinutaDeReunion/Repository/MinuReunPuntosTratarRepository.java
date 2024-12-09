package com.api.login.Documentos.MinutaDeReunion.Repository;

import com.api.login.Documentos.MinutaDeReunion.Pojo.MinuReunPuntosTratar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MinuReunPuntosTratarRepository extends JpaRepository<MinuReunPuntosTratar, Long> {
    List<MinuReunPuntosTratar> findByMinutaReunion_IdMinutaReunion(Long idMinutaReunion);
}
