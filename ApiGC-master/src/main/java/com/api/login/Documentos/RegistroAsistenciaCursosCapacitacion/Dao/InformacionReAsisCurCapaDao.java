package com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Dao;

import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Pojo.InformacionReAsisCurCapa;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InformacionReAsisCurCapaDao extends JpaRepository<InformacionReAsisCurCapa, Long> {

    Optional<InformacionReAsisCurCapa> findByReAsisCurCapaIdReAsisCurCapa(Long id);
}
