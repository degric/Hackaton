package com.api.login.Documentos.ConstanciaInduccion.Repository;

import com.api.login.Documentos.ConstanciaInduccion.Pojo.ColaboradorConsInduc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ColaboradorConsInducRepository extends JpaRepository<ColaboradorConsInduc, Long> {
    Optional<ColaboradorConsInduc> findByConstanciaInduccion_IdConstanciaInduccion(Long idConstanciaInduccion);
}
