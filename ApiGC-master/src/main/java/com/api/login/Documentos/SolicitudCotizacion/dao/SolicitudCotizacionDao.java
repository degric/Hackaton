package com.api.login.Documentos.SolicitudCotizacion.dao;

import com.api.login.Documentos.SolicitudCotizacion.pojo.SolicitudCotizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudCotizacionDao extends JpaRepository<SolicitudCotizacion, Integer> {
}
