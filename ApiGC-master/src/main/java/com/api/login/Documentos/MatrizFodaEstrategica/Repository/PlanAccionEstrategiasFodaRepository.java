package com.api.login.Documentos.MatrizFodaEstrategica.Repository;

import com.api.login.Documentos.MatrizFodaEstrategica.Pojo.PlanAccionEstrategiasFoda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlanAccionEstrategiasFodaRepository extends JpaRepository<PlanAccionEstrategiasFoda, Long> {
    List<PlanAccionEstrategiasFoda> findByMatrizFodaEstrategica_IdMatrizFodaEstrategica(Long idMatrizFodaEstrategica);

    PlanAccionEstrategiasFoda findByTipoAndEstrategias(String tipo, String estrategia);
}
