package com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.Repository;

import com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.Pojo.SeguiAccioMejoCorrePrev;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeguiAccioMejoCorrePrevRepository extends JpaRepository<SeguiAccioMejoCorrePrev, Long> {
}
