package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Repository;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.IRDNoConformidadesAcCorrectivas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRDNoConformidadesAcCorrectivasRepository extends JpaRepository<IRDNoConformidadesAcCorrectivas, Long> {
    List<IRDNoConformidadesAcCorrectivas> findByInformeRevisionDireccion_IdInformeRevisionDireccion(Long idInformeRevisionDireccion);
}

