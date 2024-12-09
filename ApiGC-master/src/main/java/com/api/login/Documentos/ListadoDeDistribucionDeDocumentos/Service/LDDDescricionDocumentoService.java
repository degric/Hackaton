package com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.Service;

import com.api.login.Documentos.ListadoDeDistribucionDeDocumentos.DTO.LDDDescricionDocumentoDTO;

import java.util.List;

public interface LDDDescricionDocumentoService {

    List<LDDDescricionDocumentoDTO> findAll();

    LDDDescricionDocumentoDTO findById(Long id);

    List<LDDDescricionDocumentoDTO> findByListadoDistribucionDocumentos(Long idListadoDistribucionDocumentos);

    LDDDescricionDocumentoDTO save(LDDDescricionDocumentoDTO lddDescricionDocumentoDTO);

    LDDDescricionDocumentoDTO update(Long id, LDDDescricionDocumentoDTO lddDescricionDocumentoDTO);

    void deleteById(Long id);
}
