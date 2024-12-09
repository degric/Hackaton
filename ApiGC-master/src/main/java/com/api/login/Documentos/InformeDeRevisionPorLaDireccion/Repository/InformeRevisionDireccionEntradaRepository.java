package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Repository;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.InformeRevisionDireccionEntrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InformeRevisionDireccionEntradaRepository extends JpaRepository<InformeRevisionDireccionEntrada, Long> {
    List<InformeRevisionDireccionEntrada> findByInformeRevisionDireccion_IdInformeRevisionDireccion(Long idInformeRevisionDireccion);
}

