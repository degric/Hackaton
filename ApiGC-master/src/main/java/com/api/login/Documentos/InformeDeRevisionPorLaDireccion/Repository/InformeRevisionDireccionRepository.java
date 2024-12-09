package com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Repository;

import com.api.login.Documentos.InformeDeRevisionPorLaDireccion.Pojo.InformeRevisionDireccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformeRevisionDireccionRepository extends JpaRepository<InformeRevisionDireccion, Long> {
}
