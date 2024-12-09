package com.api.login.Documentos.ConstanciaInduccion.Repository;

import com.api.login.Documentos.ConstanciaInduccion.Pojo.ConstanciaInduccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstanciaInduccionRepository extends JpaRepository<ConstanciaInduccion, Long> {
}
