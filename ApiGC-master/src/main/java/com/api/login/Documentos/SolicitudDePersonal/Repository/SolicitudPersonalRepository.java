package com.api.login.Documentos.SolicitudDePersonal.Repository;

import com.api.login.Documentos.SolicitudDePersonal.Pojo.SolicitudPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudPersonalRepository extends JpaRepository<SolicitudPersonal, Long> {
}

