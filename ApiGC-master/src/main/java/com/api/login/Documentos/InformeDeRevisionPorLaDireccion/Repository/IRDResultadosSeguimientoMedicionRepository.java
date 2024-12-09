package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Repository;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.IRDResultadosSeguimientoMedicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRDResultadosSeguimientoMedicionRepository extends JpaRepository<IRDResultadosSeguimientoMedicion, Long> {
    List<IRDResultadosSeguimientoMedicion> findByInformeRevisionDireccion_IdInformeRevisionDireccion(Long idInformeRevisionDireccion);
}

