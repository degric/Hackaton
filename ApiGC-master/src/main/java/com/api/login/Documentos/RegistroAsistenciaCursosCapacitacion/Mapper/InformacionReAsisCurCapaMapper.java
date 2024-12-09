package com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Mapper;

import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.DTO.InformacionReAsisCurCapaDTO;
import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Pojo.InformacionReAsisCurCapa;
import com.api.login.Documentos.RegistroAsistenciaCursosCapacitacion.Pojo.ReAsisCurCapa;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class InformacionReAsisCurCapaMapper {

    public InformacionReAsisCurCapaDTO toDTOInReAs(InformacionReAsisCurCapa entity){

        InformacionReAsisCurCapaDTO dto = new InformacionReAsisCurCapaDTO();
        dto.setIdInformacionReAsisCurCapa(entity.getIdInformacionReAsisCurCapa());
        dto.setFecha(entity.getFecha());
        dto.setNomCurso(entity.getNomCurso());
        dto.setInstructor(entity.getInstructor());
        dto.setDuracion(entity.getDuracion());
        dto.setResponsable(entity.getResponsable());
        dto.setIdReAsisCurCapa(entity.getReAsisCurCapa().getIdReAsisCurCapa());
        return dto;
    }

    public InformacionReAsisCurCapa toEntityInReAs(InformacionReAsisCurCapaDTO dto, ReAsisCurCapa reAsisCurCapa){
        InformacionReAsisCurCapa entity = new InformacionReAsisCurCapa();

        entity.setIdInformacionReAsisCurCapa(dto.getIdInformacionReAsisCurCapa());
        entity.setFecha(dto.getFecha());
        entity.setNomCurso(dto.getNomCurso());
        entity.setInstructor(dto.getInstructor());
        entity.setDuracion(dto.getDuracion());
        entity.setResponsable(dto.getResponsable());
        entity.setReAsisCurCapa(reAsisCurCapa);

        return entity;
    }

}
