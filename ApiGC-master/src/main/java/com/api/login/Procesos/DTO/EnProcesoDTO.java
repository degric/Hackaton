package com.api.login.Procesos.DTO;

import com.api.login.Procesos.Pojo.AbreProdeso;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Data
public class EnProcesoDTO {
    private Long idEnProceso;

    private LocalDate fechaElaboracion;

    private LocalDate fechaEdicion;

    private String noRevision;

    private String coDocumento;

    private String nombreProceso;

    private String coPie;

    private ObjetivoProcesoDTO objetivoProceso;

    private AlcanceProcesoDTO alcanceProceso;

    private List<DoReferenciaProcesoDTO> doReferenciaProceso;

    private List<ResponsaProcesoDTO> responsaProceso;

    private List<AbreProdesoDTO> abreProdeso;

    private List<DesarrolloProcesoDTO> desarrolloProceso;

    private List<DiTortugaProcesoDTO> diTortugaProceso;

    private DistribucionProcesoDTO distribucionProceso;

    private List<DocumentosReProcesosDTO> documentosReProcesos;

    private List<HisRevisionesProcesoDTO> hisRevisionesProceso;
}
