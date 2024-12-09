package com.api.login.Documentos.ProgramaAnualCapacitacion.Repository;

import com.api.login.Documentos.ProgramaAnualCapacitacion.Pojo.TablaProAnualCapacitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TablaProAnualCapacitacionRepository extends JpaRepository<TablaProAnualCapacitacion, Long> {
    List<TablaProAnualCapacitacion> findByProAnualCapacitacion_IdProAnualCapacitacion(Long idProAnualCapacitacion);
}
