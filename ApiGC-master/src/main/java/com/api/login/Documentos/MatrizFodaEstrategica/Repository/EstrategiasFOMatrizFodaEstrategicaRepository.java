package com.api.login.Documentos.MatrizFodaEstrategica.Repository;

import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.EstrategiasFOMatrizFodaEstrategica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EstrategiasFOMatrizFodaEstrategicaRepository extends JpaRepository<EstrategiasFOMatrizFodaEstrategica, Long> {
    List<EstrategiasFOMatrizFodaEstrategica> findByMatrizFodaEstrategica_IdMatrizFodaEstrategica(Long idMatrizFodaEstrategica);
}
