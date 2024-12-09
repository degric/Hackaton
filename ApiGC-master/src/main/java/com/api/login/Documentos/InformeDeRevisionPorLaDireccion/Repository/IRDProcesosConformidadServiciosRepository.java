package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Repository;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.IRDProcesosConformidadServicios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRDProcesosConformidadServiciosRepository extends JpaRepository<IRDProcesosConformidadServicios, Long> {
    List<IRDProcesosConformidadServicios> findByInformeRevisionDireccion_IdInformeRevisionDireccion(Long idInformeRevisionDireccion);
}
