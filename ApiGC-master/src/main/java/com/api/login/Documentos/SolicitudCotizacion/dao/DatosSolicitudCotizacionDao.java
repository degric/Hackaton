package com.api.login.Documentos.SolicitudCotizacion.dao;

import com.api.login.Documentos.SolicitudCotizacion.pojo.DatosSolicitudCotizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.services.s3.model.ObjectPart;

import java.util.Optional;

@Repository
public interface DatosSolicitudCotizacionDao extends JpaRepository<DatosSolicitudCotizacion, Integer> {
    Optional<DatosSolicitudCotizacion> findBySolicitudCotizacionIdSolicitudCotizacion(Integer id);
}
