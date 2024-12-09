package com.api.login.Documentos.ProgramaAuditoriasInternas.Service;

import com.api.login.Documentos.ProgramaAuditoriasInternas.DTO.TablaProAuInternasDTO;
import com.api.login.Documentos.ProgramaAuditoriasInternas.Pojo.TablaProAuInternas;
import org.w3c.dom.ls.LSInput;

import java.util.List;

public interface TablaProAuInternasService {

    List<TablaProAuInternasDTO> getAllTaProAuIn();

    TablaProAuInternas createTaProAuIn(TablaProAuInternasDTO dto);

    TablaProAuInternasDTO updatetaProAuIn(Integer id, TablaProAuInternasDTO dto);

    void deleteTaProAuIn(Integer id);

    List<TablaProAuInternasDTO> getByIdProgramaAuInternas(Integer id);
}
