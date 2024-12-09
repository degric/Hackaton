package com.api.login.Documentos.MejoraContinua.Repository;

import com.api.login.Documentos.MejoraContinua.Pojo.IntegrantesMejoraContinua;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IntegrantesMejoraContinuaRepository extends JpaRepository<IntegrantesMejoraContinua, Long> {
    List<IntegrantesMejoraContinua> findByMejoraContinua_IdMejoraContinua(Long idMejoraContinua);
}
