package com.api.login.Documentos.SolicitudDePersonal.Repository;

import com.api.login.Documentos.SolicitudDePersonal.Pojo.DatosSolicitudPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DatosSolicitudPersonalRepository extends JpaRepository<DatosSolicitudPersonal, Long> {
    Optional<DatosSolicitudPersonal> findBySolicitudPersonal_IdSolicitudPersonal(Long idSolicitudPersonal);
}

