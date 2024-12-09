package com.api.login.Documentos.ProgramaAnualCapacitacion.Repository;

import com.api.login.Documentos.ProgramaAnualCapacitacion.Pojo.ProAnualCapacitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProAnualCapacitacionRepository extends JpaRepository<ProAnualCapacitacion, Long> {
}
