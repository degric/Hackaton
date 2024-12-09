package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Repository;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.EntradasRevisiondireccion_A;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntradasRevisiondireccion_ARepository extends JpaRepository<EntradasRevisiondireccion_A, Long> {
    List<EntradasRevisiondireccion_A> findByInformeRevisionDireccion_IdInformeRevisionDireccion(Long idInformeRevisionDireccion);
}
