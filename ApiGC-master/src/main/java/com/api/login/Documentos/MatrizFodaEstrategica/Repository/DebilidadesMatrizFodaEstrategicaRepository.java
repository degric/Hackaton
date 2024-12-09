package com.api.login.Documentos.MatrizFodaEstrategica.Repository;

import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.DebilidadesMatrizFodaEstrategica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DebilidadesMatrizFodaEstrategicaRepository extends JpaRepository<DebilidadesMatrizFodaEstrategica, Long> {
    List<DebilidadesMatrizFodaEstrategica> findByMatrizFodaEstrategica_IdMatrizFodaEstrategica(Long idMatrizFodaEstrategica);
}

