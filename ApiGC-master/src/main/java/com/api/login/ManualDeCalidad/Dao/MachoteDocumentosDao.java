package com.api.login.ManualDeCalidad.Dao;

import com.api.login.ManualDeCalidad.pojo.MachoteDocumentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MachoteDocumentosDao extends JpaRepository<MachoteDocumentos, Long> {

    Optional<MachoteDocumentos> findByNombreDocumento(String nombre);

    List<MachoteDocumentos> findByNivelDocumento(Long nivel);
}
