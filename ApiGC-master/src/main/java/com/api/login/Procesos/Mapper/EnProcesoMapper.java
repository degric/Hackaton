package com.api.login.Procesos.Mapper;

import com.api.login.Procesos.DTO.EnProcesoDTO;
import com.api.login.Procesos.DTO.EnProcesoDTOSinListas;
import com.api.login.Procesos.DTO.ObjetivoProcesoDTO;
import com.api.login.Procesos.Pojo.AlcanceProceso;
import com.api.login.Procesos.Pojo.DoReferenciaProceso;
import com.api.login.Procesos.Pojo.EnProceso;
import com.api.login.Procesos.Pojo.ObjetivoProceso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EnProcesoMapper {

    @Autowired
    private ObjetivoProcesoMapper objetivoProcesoMapper;

    @Autowired
    private AlcanceProcesoMapper alcanceProcesoMapper;

    @Autowired
    private DoReferenciaProcesoMapper doReferenciaProcesoMapper;

    @Autowired
    private AbreProdesoMapper abreProdesoMapper;

    @Autowired
    private DesarrolloProcesoMapper desarrolloProcesoMapper;

    @Autowired
    private DiTortugaProcesoMapper diTortugaProcesoMapper;

    @Autowired
    private DistribucionProcesoMapper distribucionProcesoMapper;

    @Autowired
    private ResponsaProcesoMapper responsaProcesoMapper;

    @Autowired
    private HisRevisionesProcesoMapper hisRevisionesProcesoMapper;

    @Autowired
    private DocumentosReProcesosMapper documentosReProcesosMapper;

    public EnProcesoDTO toDTOEnProceso(EnProceso entity){
        EnProcesoDTO dto = new EnProcesoDTO();
        if (entity != null) {
        dto.setIdEnProceso(entity.getIdEnProceso());
        dto.setFechaElaboracion(entity.getFechaElaboracion());
        dto.setFechaEdicion(entity.getFechaEdicion());
        dto.setNoRevision(entity.getNoRevision());
        dto.setCoDocumento(entity.getCoDocumento());
        dto.setNombreProceso(entity.getNombreProceso());
        dto.setCoPie(entity.getCoPie());


        //se Mapean los casos de uso para las tablas relacionadas
        dto.setObjetivoProceso(
            entity.getObjetivoProceso() != null
                 ? objetivoProcesoMapper.toDTOObProceso(entity.getObjetivoProceso())
                 : null
            );
        dto.setAlcanceProceso(
                entity.getAlcanceProceso() != null
                ? alcanceProcesoMapper.toDTOAlProceso(entity.getAlcanceProceso())
                        :null
        );

        if (entity.getDoReferenciaProceso() != null){
            dto.setDoReferenciaProceso(entity.getDoReferenciaProceso().stream()
                    .map(doReferenciaProcesoMapper::toDTODoReferencia)
                    .collect(Collectors.toList()));
        }else {
            dto.setDoReferenciaProceso(Collections.emptyList());
        }

        dto.setResponsaProceso(
                entity.getResponsaProcesos() != null
                ?entity.getResponsaProcesos().stream().map(responsaProcesoMapper::toDTO).collect(Collectors.toList())
                        :Collections.emptyList()
        );

        if (entity.getAbreProdesos() != null){
            dto.setAbreProdeso(entity.getAbreProdesos().stream()
                    .map(abreProdesoMapper::toDTOAbreProceso)
                    .collect(Collectors.toList()));
        }else{
            dto.setAbreProdeso(Collections.emptyList());
        }

        dto.setDesarrolloProceso(
                entity.getDesarrolloProceso() != null
                ? entity.getDesarrolloProceso().stream().map(desarrolloProcesoMapper::toDTODesarrolloProceso).collect(Collectors.toList())
                        :Collections.emptyList()
        );

        dto.setDiTortugaProceso(
                entity.getDiTortugaProcesos() != null
                ? entity.getDiTortugaProcesos().stream().map(diTortugaProcesoMapper::toDTODiTortugaProceso).collect(Collectors.toList())
                        :Collections.emptyList()
        );

        dto.setDistribucionProceso(
                entity.getDistribucionProceso() != null
                ? distribucionProcesoMapper.toDTODistribucion(entity.getDistribucionProceso())
                        :null
        );

        dto.setDocumentosReProcesos(
                entity.getDocumentosReProcesos() != null
                ? entity.getDocumentosReProcesos().stream().map(documentosReProcesosMapper ::toDTO).collect(Collectors.toList())
                        :Collections.emptyList()
        );

        dto.setHisRevisionesProceso(
                entity.getHisRevisionesProcesos() != null
                ? entity.getHisRevisionesProcesos().stream().map(hisRevisionesProcesoMapper::toDTOHisRevisionesProceso).collect(Collectors.toList())
                        :Collections.emptyList()
        );
        } else {
            // Manejar el caso donde entity es null
            dto.setObjetivoProceso(null);
            // O lanzar una excepción si es un caso que no debería ocurrir
            // throw new IllegalArgumentException("Entity cannot be null");
        }
        //dto.setObjetivoProceso(objetivoProcesoMapper.toDTOObProceso(entity.getObjetivoProceso()));
        return dto;
    }



    public EnProceso toEntityEnProceso(EnProcesoDTO dto){
        EnProceso entity = new EnProceso();

        entity.setIdEnProceso(dto.getIdEnProceso());
        entity.setFechaElaboracion(dto.getFechaElaboracion());
        entity.setFechaEdicion(dto.getFechaEdicion());
        entity.setNoRevision(dto.getNoRevision());
        entity.setCoDocumento(dto.getCoDocumento());
        entity.setNombreProceso(dto.getNombreProceso());
        entity.setCoPie(dto.getCoPie());

        //seteo de obejto para guardarlo en primer paso
        if (dto.getObjetivoProceso() != null){
            ObjetivoProceso objetivoProceso = objetivoProcesoMapper.toEntityObProceso(dto.getObjetivoProceso(), entity);
            entity.setObjetivoProceso(objetivoProceso);
        }

        //seteo de Alcance para guardarlo en primer paso
        if (dto.getAlcanceProceso() != null){
            AlcanceProceso alcanceProceso = alcanceProcesoMapper.toEntityAlProceso(dto.getAlcanceProceso(),entity);
            entity.setAlcanceProceso(alcanceProceso);
        }

        //seteo de Documentos de Referencia para guardarlo en primer paso
        if (dto.getDoReferenciaProceso() != null){
            List<DoReferenciaProceso> doReferenciaProcesos = dto.getDoReferenciaProceso().stream()
                    .map(doReferenciaProcesoDTO -> doReferenciaProcesoMapper.toEntityDoReferencia(doReferenciaProcesoDTO, entity))
                    .collect(Collectors.toList());
            entity.setDoReferenciaProceso(doReferenciaProcesos);
        }
        return entity;
    }

    public EnProcesoDTOSinListas toDTOEnProcesoSinListas(EnProceso entity) {
        EnProcesoDTOSinListas dto = new EnProcesoDTOSinListas();
        dto.setIdEnProceso(entity.getIdEnProceso());
        dto.setFechaElaboracion(entity.getFechaElaboracion());
        dto.setFechaEdicion(entity.getFechaEdicion());
        dto.setNoRevision(entity.getNoRevision());
        dto.setCoDocumento(entity.getCoDocumento());
        dto.setNombreProceso(entity.getNombreProceso());
        dto.setCoPie(entity.getCoPie());

        return dto;


    }
}
