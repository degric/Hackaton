package com.api.login.Documentos.MejoraContinua.Repository;

import com.api.login.Documentos.MejoraContinua.Pojo.DatosMejoraContinua;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DatosMejoraContinuaRepository extends JpaRepository<DatosMejoraContinua, Long> {
    Optional<DatosMejoraContinua> findByMejoraContinua_IdMejoraContinua(Long idMejoraContinua);
}

