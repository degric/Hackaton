package com.api.login.Documentos.MejoraContinua.Repository;

import com.api.login.Documentos.MejoraContinua.Pojo.MejoraContinua;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MejoraContinuaRepository extends JpaRepository<MejoraContinua, Long> {
}

