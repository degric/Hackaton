package com.api.login.Documentos.MatrizFodaEstrategica.Repository;

import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.FortalezasMatrizFodaEstrategica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FortalezasMatrizFodaEstrategicaRepository extends JpaRepository<FortalezasMatrizFodaEstrategica, Long> {
    List<FortalezasMatrizFodaEstrategica> findByMatrizFodaEstrategica_IdMatrizFodaEstrategica(Long idMatrizFodaEstrategica);
}

