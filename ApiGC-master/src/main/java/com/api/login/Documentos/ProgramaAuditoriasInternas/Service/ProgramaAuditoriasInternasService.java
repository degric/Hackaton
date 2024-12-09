package com.api.login.Documentos.ProgramaAuditoriasInternas.Service;

import com.api.login.Documentos.ProgramaAuditoriasInternas.DTO.ProgramaAuditoriasInternasDTO;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Pojo.ProgramaAuditoriasInternas;
import software.amazon.awssdk.services.s3.endpoints.internal.Value;

import java.util.List;
import java.util.Optional;

public interface ProgramaAuditoriasInternasService {
    List<ProgramaAuditoriasInternasDTO> getAllProAuIn();

    Optional<ProgramaAuditoriasInternasDTO> getByIdProAuIn(Integer id);

    ProgramaAuditoriasInternasDTO createProAuIn(ProgramaAuditoriasInternasDTO dto);

    ProgramaAuditoriasInternasDTO updateProAuIn(Integer id, ProgramaAuditoriasInternasDTO dto);

    void deleteProAuIn(Integer id);
}
