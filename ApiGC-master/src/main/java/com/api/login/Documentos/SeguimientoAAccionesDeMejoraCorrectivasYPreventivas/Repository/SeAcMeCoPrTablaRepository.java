package com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.Repository;

import com.api.login.Documentos.SeguimientoAAccionesDeMejoraCorrectivasYPreventivas.Pojo.SeAcMeCoPrTabla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeAcMeCoPrTablaRepository extends JpaRepository<SeAcMeCoPrTabla, Long> {
    List<SeAcMeCoPrTabla> findBySeguiAccioMejoCorrePrev_IdSeguiAccioMejoCorrePrev(Long idSeguiAccioMejoCorrePrev);
}

