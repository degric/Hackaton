package com.api.login.Documentos.ProgramaAuditoriasInternas.Service;

import com.api.login.Documentos.ProgramaAuditoriasInternas.DTO.ObservacionesProAuInternasDTO;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Pojo.ObservacionesProAuInternas;

import java.util.List;

public interface ObservacionesProAuInternasService {
    List<ObservacionesProAuInternasDTO> getAllObProAuIn();

    ObservacionesProAuInternas createObProAuIn(ObservacionesProAuInternasDTO dto);

    ObservacionesProAuInternasDTO updateObProAuIn(Integer id, ObservacionesProAuInternasDTO dto);

    void deleteObProAuIn(Integer id);

    List<ObservacionesProAuInternasDTO> getObProAuInByIdProAuIn(Integer id);
}
