package com.api.login.Documentos.MatrizFodaEstrategica.Repository;

import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.EstrategiasFAMatrizFodaEstrategica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EstrategiasFAMatrizFodaEstrategicaRepository extends JpaRepository<EstrategiasFAMatrizFodaEstrategica, Long> {
    List<EstrategiasFAMatrizFodaEstrategica> findByMatrizFodaEstrategica_IdMatrizFodaEstrategica(Long idMatrizFodaEstrategica);
}

