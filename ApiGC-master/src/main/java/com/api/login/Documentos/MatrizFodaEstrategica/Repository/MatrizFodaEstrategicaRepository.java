package com.api.login.Documentos.MatrizFodaEstrategica.Repository;

import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.MatrizFodaEstrategica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatrizFodaEstrategicaRepository extends JpaRepository<MatrizFodaEstrategica, Long> {
}

