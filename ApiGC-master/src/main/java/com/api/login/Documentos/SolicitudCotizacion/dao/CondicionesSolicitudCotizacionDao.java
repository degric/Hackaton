package com.api.login.Documentos.SolicitudCotizacion.dao;

import com.api.login.Documentos.SolicitudCotizacion.pojo.CondicionesSolicitudCotizacion;
import com.api.login.pojo.FirmaLisDisDocumentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CondicionesSolicitudCotizacionDao extends JpaRepository<CondicionesSolicitudCotizacion, Integer> {

    //List<FirmaLisDisDocumentos> findByLisDisDocumentosIdLisDisDocumentos(Integer id);

    Optional<CondicionesSolicitudCotizacion> findBySolicitudCotizacionIdSolicitudCotizacion(Integer id);
}
