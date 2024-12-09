package com.api.login.Documentos.MatrizFodaEstrategica.Repository;

import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.EstrategiasDOMatrizFodaEstrategica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EstrategiasDOMatrizFodaEstrategicaRepository extends JpaRepository<EstrategiasDOMatrizFodaEstrategica, Long> {
    List<EstrategiasDOMatrizFodaEstrategica> findByMatrizFodaEstrategica_IdMatrizFodaEstrategica(Long idMatrizFodaEstrategica);
}
