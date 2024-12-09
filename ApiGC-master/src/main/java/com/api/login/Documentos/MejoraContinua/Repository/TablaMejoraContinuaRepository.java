package com.api.login.Documentos.MejoraContinua.Repository;

import com.api.login.Documentos.MejoraContinua.Pojo.TablaMejoraContinua;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TablaMejoraContinuaRepository extends JpaRepository<TablaMejoraContinua, Long> {
    List<TablaMejoraContinua> findByMejoraContinua_IdMejoraContinua(Long idMejoraContinua);
}

