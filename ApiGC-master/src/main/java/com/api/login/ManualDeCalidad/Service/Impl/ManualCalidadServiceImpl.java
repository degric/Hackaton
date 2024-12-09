package com.api.login.ManualDeCalidad.Service.Impl;

import com.api.login.ManualDeCalidad.DTO.ManualCalidadDTO;
import com.api.login.ManualDeCalidad.Dao.*;
import com.api.login.ManualDeCalidad.Mapper.ManualCalidadMapper;
import com.api.login.ManualDeCalidad.pojo.*;
import com.api.login.ManualDeCalidad.Service.ManualCalidadService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ManualCalidadServiceImpl implements ManualCalidadService {

    @Autowired
    private ManualCalidadDao manualCalidadRepository;

    @Autowired
    private ManualCalidadMapper mapper;;

    @Autowired
    private IntroduccionManualDao introduccionManualRepository;

    @Autowired
    private ObjetivoManualDao objetivoManualRepository;

    @Autowired
    private NormasReferenciaManualDao normasReferenciaManualRepository;

    @Autowired
    private ContextoOrganizacionManualDao contextoOrganizacionManualRepository;

    @Autowired
    private LiderazgoManualDao liderazgoManualRepository;

    @Autowired
    private PlanificacionManualDao planificacionManualRepository;

    @Autowired
    private ApoyoManualDao apoyoManualRepository;

    @Autowired
    private EvaluacionDesemManualDao evaluacionDesemManualRepository;

    @Autowired
    private TablaEvaluacionDesempenoManualDao tablaEvaluacionDesempenoManualRepository;

    @Autowired
    private MejoraManualDao mejoraManualRepository;


    @Autowired
    private OperacionManualDao operacionManualRepository;

    @Override
    public List<ManualCalidad> findAllManualC() {
        return manualCalidadRepository.findAll();
    }

    @Override
    public ManualCalidad findByIdManualC(Long id) {
        Optional<ManualCalidad> optionalManualCalidad = manualCalidadRepository.findById(id);
        return optionalManualCalidad.orElse(null);
    }


    @Override
    public ManualCalidad copyManualC(Long id){
        Optional<ManualCalidad> nuevoManual = manualCalidadRepository.findById(id);

        if (nuevoManual.isPresent()){
        ManualCalidad manualCalidad = nuevoManual.get();

        //guardado del nuevo encabezado
        ManualCalidad saveManual = new ManualCalidad();
        saveManual.setFechaEmision(manualCalidad.getFechaEmision());
        saveManual.setFechaRevision(manualCalidad.getFechaRevision());
        saveManual.setCoDocumento(manualCalidad.getCoDocumento());
        saveManual.setCoDocumento(manualCalidad.getCoDocumento());
        saveManual.setCoPie(manualCalidad.getCoPie());

        ManualCalidad manualSave = manualCalidadRepository.save(saveManual);

        //llenado de introduciion
        List<IntroduccionManual> introduccionManualList = introduccionManualRepository.findByManualCalidadIdManualCalidad(manualCalidad.getIdManualCalidad());
        if (!introduccionManualList.isEmpty()){
        for (IntroduccionManual introduccionManual : introduccionManualList){
            IntroduccionManual introduccionM = new IntroduccionManual();
            introduccionM.setManualCalidad(manualSave);
            introduccionM.setTitulo(introduccionManual.getTitulo());
            introduccionM.setContenido(introduccionManual.getContenido());

            introduccionManualRepository.save(introduccionM);
        }
        }

        //llenado de Objetivo
        List<ObjetivoManual> objetivoManualList = objetivoManualRepository.findByManualCalidadIdManualCalidad(manualCalidad.getIdManualCalidad());
        for (ObjetivoManual objetivoManual : objetivoManualList){
            ObjetivoManual objetivoM = new ObjetivoManual();
            objetivoM.setObjetivo(objetivoManual.getObjetivo());
            objetivoM.setManualCalidad(manualSave);
            objetivoManualRepository.save(objetivoM);
        }
        //objetivoManualRepository.saveAll(objetivoManualList);

        //llenado de Normas de Referencia
        List<NormasReferenciaManual> normasReferenciaManuals1 = normasReferenciaManualRepository.findByManualCalidadIdManualCalidad(manualCalidad.getIdManualCalidad());
        for (NormasReferenciaManual normasReferenciaManual : normasReferenciaManuals1){
             NormasReferenciaManual normasReferenciaM = new NormasReferenciaManual();
             normasReferenciaM.setNorma(normasReferenciaManual.getNorma());
             normasReferenciaM.setDescripcion(normasReferenciaManual.getDescripcion());
             normasReferenciaM.setManualCalidad(manualSave);
             normasReferenciaManualRepository.save(normasReferenciaM);
        }

        //llenado CONTEXTO DE LA ORGANIZACIÓN
        List<ContextoOrganizacionManual> contextoOrganizacionManualList = contextoOrganizacionManualRepository.findByManualCalidadIdManualCalidad(manualCalidad.getIdManualCalidad());
        for (ContextoOrganizacionManual contextoOrganizacionManual : contextoOrganizacionManualList){
            ContextoOrganizacionManual contextoOrganizacionManual1 = new ContextoOrganizacionManual();
            contextoOrganizacionManual1.setTitulo(contextoOrganizacionManual.getTitulo());
            contextoOrganizacionManual1.setContenido(contextoOrganizacionManual.getContenido());
            contextoOrganizacionManual1.setManualCalidad(manualSave);
            contextoOrganizacionManualRepository.save(contextoOrganizacionManual1);
        }

        //Liderazgo
        List<LiderazgoManual> liderazgoManualList = liderazgoManualRepository.findByManualCalidadIdManualCalidad(manualCalidad.getIdManualCalidad());
        for (LiderazgoManual liderazgoManual : liderazgoManualList){
            LiderazgoManual liderazgoManual1 = new LiderazgoManual();
            liderazgoManual1.setTitulo(liderazgoManual.getTitulo());
            liderazgoManual1.setContenido(liderazgoManual.getContenido());
            liderazgoManual1.setManualCalidad(manualSave);
            liderazgoManualRepository.save(liderazgoManual1);
        }

        //Planificacion
        List<PlanificacionManual> planificacionManualList = planificacionManualRepository.findByManualCalidadIdManualCalidad(manualCalidad.getIdManualCalidad());
        for (PlanificacionManual planificacionManual : planificacionManualList){
            PlanificacionManual planificacionManual1 = new PlanificacionManual();
            planificacionManual1.setTitulo(planificacionManual.getTitulo());
            planificacionManual1.setContenido(planificacionManual.getContenido());
            planificacionManual1.setManualCalidad(manualSave);
            planificacionManualRepository.save(planificacionManual1);
        }

        //Apoyo
        List<ApoyoManual> apoyoManuals = apoyoManualRepository.findByManualCalidadIdManualCalidad(manualCalidad.getIdManualCalidad());
        for (ApoyoManual apoyoManual : apoyoManuals){
            ApoyoManual apoyoManual1 = new ApoyoManual();
            apoyoManual1.setTitulo(apoyoManual.getTitulo());
            apoyoManual1.setContenido(apoyoManual.getContenido());
            apoyoManual1.setManualCalidad(manualSave);
            apoyoManualRepository.save(apoyoManual1);
        }


        //EVALUACIÓN DEL DESEMPEÑO
        List<EvaluacionDesemManual> evaluacionDesemManualList = evaluacionDesemManualRepository.findByManualCalidadIdManualCalidad(manualCalidad.getIdManualCalidad());
        for (EvaluacionDesemManual evaluacionDesemManual : evaluacionDesemManualList){
            EvaluacionDesemManual evaluacionDesemManual1 = new EvaluacionDesemManual();
            evaluacionDesemManual1.setTitulo(evaluacionDesemManual.getTitulo());
            evaluacionDesemManual1.setContenido(evaluacionDesemManual.getContenido());
            evaluacionDesemManual1.setManualCalidad(manualSave);
            evaluacionDesemManualRepository.save(evaluacionDesemManual1);
        }

        //tabla de EVALUACIÓN DEL DESEMPEÑO
        List<TablaEvaluacionDesempenoManual> tablaEvaluacionDesempenoManualList = tablaEvaluacionDesempenoManualRepository.findByManualCalidadIdManualCalidad(manualCalidad.getIdManualCalidad());
        for (TablaEvaluacionDesempenoManual tablaEvaluacionDesempenoManual : tablaEvaluacionDesempenoManualList){
            TablaEvaluacionDesempenoManual tablaEvaluacionDesempenoManual1 = new TablaEvaluacionDesempenoManual();
            tablaEvaluacionDesempenoManual1.setQueEvaluar(tablaEvaluacionDesempenoManual.getQueEvaluar());
            tablaEvaluacionDesempenoManual1.setMetodoSeguimientoMedicion(tablaEvaluacionDesempenoManual.getMetodoSeguimientoMedicion());
            tablaEvaluacionDesempenoManual1.setCuandoDarSeguimientoMedicion(tablaEvaluacionDesempenoManual.getCuandoDarSeguimientoMedicion());
            tablaEvaluacionDesempenoManual1.setCuandoAnalizarEvaluarResultados(tablaEvaluacionDesempenoManual.getCuandoAnalizarEvaluarResultados());
            tablaEvaluacionDesempenoManual1.setManualCalidad(manualSave);
            tablaEvaluacionDesempenoManualRepository.save(tablaEvaluacionDesempenoManual1);
        }

        //MEJORA
        List<MejoraManual> mejoraManualList = mejoraManualRepository.findByManualCalidadIdManualCalidad(manualCalidad.getIdManualCalidad());
            for (MejoraManual mejoraManual : mejoraManualList){
                MejoraManual mejoraManual1 = new MejoraManual();
                mejoraManual1.setTitulo(mejoraManual.getTitulo());
                mejoraManual1.setContenido(mejoraManual.getContenido());
                mejoraManual1.setManualCalidad(manualSave);
                mejoraManualRepository.save(mejoraManual1);
            }
        return manualSave;
        }
        return null;


    }

    @Override
    @Transactional
    public ManualCalidad saveManualC(ManualCalidad manualCalidad) {
        ManualCalidad nuevoManual = manualCalidadRepository.save(manualCalidad);

        //llenado de Objetivo
        ObjetivoManual[] objetivoManuals = {
                new ObjetivoManual(null,"La Finalidad del presente manual es definir y describir la estructura operativa de nuestro Sistema de Gestión de la Calidad (SGC) como " +
                        "{Nombre de la empresa} " +
                        "en conformidad con los requisitos establecidos en la norma ISO 9001:2015.\n" +
                        "Nuestro sistema se establece con el principio del enfoque de procesos para aumentar la rentabilidad operativa e incrementar la satisfacción de " +
                        "nuestros clientes. Es aplicado en nuestros procesos de servicio enfocados en la filosofía de mejoramiento continuo.\n",nuevoManual)
                };
        List<ObjetivoManual> objetivoManualList = new ArrayList<>(Arrays.asList(objetivoManuals));
        objetivoManualRepository.saveAll(objetivoManualList);

        //llenado de Normas de Referencia
        NormasReferenciaManual[] normasReferenciaManuals = {
                new NormasReferenciaManual(null,"ISO-9000:2015/NMX-CC-9000-IMNC-2015","Sistema de Gestión de la calidad – Fundamentos y vocabulario.",nuevoManual),
                new NormasReferenciaManual(null,"ISO-9001:2015/NMX-CC-9001-IMNC-2015","Sistema de Gestión de la calidad – Requisitos.",nuevoManual),
                new NormasReferenciaManual(null,"ISO/TR-10013/NMX-CC-10013-IMNC-2002","Directrices para la documentación de sistemas de gestión de la calidad.",nuevoManual),
                new NormasReferenciaManual(null,"ISO 19011:2011/NMX-CC-19011-IMNC-2012","Directrices para la auditoría de los sistemas de gestión.",nuevoManual)
        };
        List<NormasReferenciaManual> normasReferenciaManuals1 = new ArrayList<>(Arrays.asList(normasReferenciaManuals));
        normasReferenciaManualRepository.saveAll(normasReferenciaManuals1);

        //llenado CONTEXTO DE LA ORGANIZACIÓN
        ContextoOrganizacionManual[] contextoOrganizacionManuals = {
                new ContextoOrganizacionManual(null,"Comprensión de la organización y su contexto","A través del Equipo Multidisciplinario responsables de los procesos considerados en el Sistema de Gestión de la Calidad, " +
                        "se lleva a cabo el análisis FODA y Matriz FODA estratégica, el cual permite comprender a la organización y su contexto (factores internos y externos) pertinentes para su dirección estratégica. \n" +
                        "-Fortalezas.\n" +
                        "-Debilidades.\n" +
                        "-Oportunidades.\n" +
                        "-Amenazas.\n",nuevoManual),
                new ContextoOrganizacionManual(null,"Comprensión de las necesidades y expectativas de las partes interesadas.","La pertenencia de las partes interesadas es determinada a través del cumplimiento de los requisitos del cliente y del Sistema de Gestión de Calidad, así como sus necesidades y expectativas dentro del Análisis FODA Organizacional.\n" +
                        "El análisis del contexto nos ayuda a determinar y comprender las partes interesadas de la organización, que pueden tener una influencia directa en el entorno de la organización y en su futuro como negocio. así como los requisitos del cliente, legales, reglamentarios y otros requisitos, para determinar sus necesidades y expectativas\n",nuevoManual),
                new ContextoOrganizacionManual(null,"Determinación del alcance del SGC.","El alcance del SGC de la organización considera los procesos internos y externos definidos en el " +
                        "contexto de la organización y los requisitos de las partes interesadas pertinentes. El alcance del SGC se define: \n" +
                        "Fabricación de Jabones, limpiadores y dentífricos en el ramo de productos de consumo de limpieza.\n",nuevoManual),
                new ContextoOrganizacionManual(null,"Sistemas de gestión de la calidad y sus procesos.","Se han definido e implementado los procesos necesarios, identificando tres tipos de " +
                        "procesos dentro del SGC de la organización: Los Procesos del SGC que permiten establecer el rumbo de la organización y evaluar el desempeño global del SGC; Los Procesos Críticos e Instructivos de Trabajo que " +
                        "corresponden a la operación de {Nombre de la empresa}. y los Procesos Administrativos que facilitan los recursos para el adecuado desarrollo de los Procedimientos Críticos e Instructivos de Trabajo. " +
                        "En el mapa de procesos se visualizan dichos procesos y su interacción. (Mapa de procesos del SGC)",nuevoManual)
        };
        List<ContextoOrganizacionManual> contextoOrganizacionManualList = new ArrayList<>(Arrays.asList(contextoOrganizacionManuals));
        contextoOrganizacionManualRepository.saveAll(contextoOrganizacionManualList);

        //Liderazgo
        LiderazgoManual[] liderazgoManual = {
                new LiderazgoManual(null,"Liderazgo y compromiso.","La alta dirección demuestra su liderazgo y compromiso con respecto al SGC, asumiendo la responsabilidad y obligación con relación a la eficacia del mismo. Se asegura que se establece la Política de Calidad y los Objetivos de la Calidad; que éstos sean compatibles con el contexto y la dirección estratégica de la organización.\n" +
                        "Promueve el enfoque de procesos y pensamiento basado en riesgos, asegurando la disponibilidad de los recursos necesarios para la eficacia de los procesos del SGC y se logren los resultados previstos. \n" +
                        "Se establece un enfoque al cliente mediante el cumplimiento de sus especificaciones y necesidades para la realización de los productos y servicios provistos. Se aplica una encuesta de satisfacción para conocer el nivel de satisfacción en cada servicio realizado.\n" +
                        "Política de Calidad.\n" +
                        "Organigrama \n" +
                        "Mapa de procesos del SGC.\n" +
                        "Análisis de Riesgo. \n",nuevoManual),
                new LiderazgoManual(null,"Política de calidad.","Se tiene establecida una política de calidad al propósito y contexto de la organización. Se comunica a todos los niveles de la organización y proporciona un marco de referencia para establecer los objetivos de calidad." +
                        "{Politica de Calidad del Sistema} \n" +
                        "La Política de comunica por cualquiera de estos medios, sin limitarse a: inducción, página web, publicaciones físicas y electrónicas. " ,nuevoManual),

                new LiderazgoManual(null,"Roles, responsabilidades y autoridades en la organización.","La coordinación del SGC se lleva a cabo a través de un nombramiento por parte de la dirección.\n" +
                        "Las responsabilidades, funciones y autoridades en la organización se definen en los perfiles de puesto y el organigrama organizacional.\n",nuevoManual)
        };
        List<LiderazgoManual> liderazgoManualList = new ArrayList<>(Arrays.asList(liderazgoManual));
        liderazgoManualRepository.saveAll(liderazgoManualList);

        //Planificacion
        PlanificacionManual[] planificacionManual = {
                new PlanificacionManual(null,"Acciones para abordar riesgo y oportunidades.","Para la planificación del SGC la alta dirección considera el contexto organizacional y la comprensión de las partes interesadas; ha definido la metodología para la gestión de riesgos y oportunidades que permita tomar acciones para abordarlos.\n" +
                        "Las acciones para abordar los riesgos son revisadas para su seguimiento y efectividad conforme al proceso de Gestión de Riesgos y Oportunidades.\n",nuevoManual),
                new PlanificacionManual(null,"Objetivos de la calidad y planificación para lograrlos.","A partir de la política de la calidad se han establecido los objetivos del SGC, los cuales permiten medir y evaluar el grado de cumplimiento del sistema y el desempeño de los procesos.\n" +
                        "Los objetivos son planificados para lograr su cumplimiento y revisados por la dirección para verificar su cumplimiento. (INCLUIR LOS OBJETIVOS)\n" +
                        "Objetivos de la Calidad.\n",nuevoManual),
                new PlanificacionManual(null,"Planificación de los cambios.","Cuando se identifican cambios en el SGC, donde impacta a otros procesos o productos; los cambios se llevan a cabo de forma planificada.\n" +
                        "Los cambios a los procedimientos se señalan en el control de cambios de cada documento.\n" +
                        "Los cambios derivados de la atención a las no conformidades se identifican en el mismo formato. Cuando los cambios afectan el logro de los objetivos, se da seguimiento al logro de los mismos.\n" +
                        "Solicitud de Cambio al Sistema de Calidad.\n" +
                        "Formato de Mejora Continua\n",nuevoManual)
        };
        List<PlanificacionManual> planificacionManualList = new ArrayList<>(Arrays.asList(planificacionManual));
        planificacionManualRepository.saveAll(planificacionManualList);



        //Apoyo
        ApoyoManual[] apoyoManual = {
                new ApoyoManual(null,"Recursos.","Se han determinado y se proporcionan los recursos necesarios para el establecimiento, implementación, mantenimiento y mejora continua del SGC, tales como:\n" +
                        "Personas: Se proporcionan (sin limitarse a:) de bolsa de trabajo, universidades o con el nivel de competencia y experiencia requerido.\n" +
                        "Infraestructura: Se determina, mantiene y establece para gestionar la operación de los procesos y lograr la conformidad del producto.  \n" +
                        "Se definen y gestionan los conocimientos necesarios para la operación y la conformidad del producto y servicio de acuerdo al puesto.\n" +
                        "Organigrama.\n" +
                        "Proceso de Contratación y Competencia del Personal.\n",nuevoManual),
                new ApoyoManual(null,"Competencia. ","La organización se asegura que todo el personal, que realiza funciones y actividades que pueden afectar la conformidad del producto / servicio, sea competente, por lo que:\n" +
                        "-Determina la competencia necesaria del personal a partir de los perfiles de puesto.\n" +
                        "-Identifica y proporciona formación u otras acciones para lograr la competencia del personal, tales como cursos de capacitación por personal interno o entidades externas y evalúa la eficacia de las acciones tomadas.\n" +
                        "-El personal se evalúa después de un periodo de entrenamiento para conocer su nivel de competencia y adaptación al puesto.\n" +
                        "Descriptivos de Puesto.\n" +
                        "Expedientes del personal.\n" +
                        "Detección de Necesidades de Capacitación (DNC).\n",nuevoManual),
                new ApoyoManual(null,"Toma de conciencia.","La organización asegura la participación en la toma de conciencia, la cual se lleva a cabo con pláticas informativas al personal, sobre el conocimiento y entendimiento de la Política de Calidad, la importancia de sus actividades en el SGC, así como su compromiso y participación en la empresa contribuyen al logro de los objetivos derivados de la política y de las implicaciones en el incumplimiento de los requisitos del SGC.\n" +
                        "Para asegurar que la Política de Calidad es comunicada y entendida dentro de la organización, se utilizan diferentes medios tales como: Banners, Mantas, screens, gafetes, y cualquier otro medio que se ajuste a la organización.\n",nuevoManual),
                new ApoyoManual(null,"Comunicación.","Se han definido canales de comunicación pertinentes para el seguimiento y retroalimentación sobre las cuestiones que afectan el funcionamiento del SGC:\n" +
                        "Juntas informativas, correos electrónicos, minutas, memorándums y cualquier otro medio que se ajuste a las necesidades de la organización.\n",nuevoManual),
                new ApoyoManual(null,"Información documentada.","Se incluye dentro del SGC la información documentada requerida por la ISO 9001: 2015, así como la documentación necesaria para cumplir con la eficacia del SGC de la organización. Para la creación, actualización y control de la información documentada, los cambios y actualizaciones son notificados por cualquier medio disponible; en los propios documentos o a través de una lista de asistencia con la capacitación correspondiente.\n" +
                        "Los documentos se resguardan en carpetas electrónicas y se crean controles de acceso de acuerdo al puesto para su consulta y recuperación.\n" +
                        "Los documentos se encuentran relacionados e identificados en una “Lista Maestra de Documentos” para la trazabilidad, control de cambios y disponibilidad.\n" +
                        "Proceso para la Elaboración de Documentos del Sistema de Gestión.\n" +
                        "Proceso para Asignar Número de Código.\n" +
                        "Proceso para el Control de los Documentos.\n" +
                        "Proceso de Control de Registros.\n",nuevoManual)
        };
        List<ApoyoManual> apoyoManuals = new ArrayList<>(Arrays.asList(apoyoManual));
        apoyoManualRepository.saveAll(apoyoManuals);


        //EVALUACIÓN DEL DESEMPEÑO
        EvaluacionDesemManual[] evaluacionDesemManuals = {
                new EvaluacionDesemManual(null,"Seguimiento, medición, análisis y evaluación.", "Se ha determinado dar seguimiento, medición, análisis y evaluación a los siguientes elementos para medir y monitorear el desempeño y la eficacia de nuestro SGC:", nuevoManual),
                new EvaluacionDesemManual(null,"Auditoría Interna.","Se ha documentado un proceso para la realización de auditorías internas; los hallazgos derivados de las mismas se responden conforme al proceso de acciones correctivas y se da seguimiento al cumplimiento de los tiempos establecidos para su atención. \n" +
                        "Se cuenta con auditores internos asignados, así como soporte de auditores externos para la realización y cumplimiento al programa de Auditorías Internas.\n" +
                        "Proceso de Auditorías Internas.\n",nuevoManual),
                new EvaluacionDesemManual(null,"Revisión por la dirección","La Dirección con apoyo de Calidad, realizan a intervalos planificados la revisión por la dirección para asegurarse de la conveniencia, adecuación, eficacia y alineación continuas con la dirección estratégica.\n" +
                        "De las revisiones por la dirección se establece oportunidades de mejora, necesidades de cambios en el SGC y necesidad de recursos y estas salidas se documentan.\n" +
                        "Programa de Revisión por Dirección.\n" +
                        "Minuta Gerencial.\n" +
                        "Balanced Score Card.\n" +
                        "Proceso para la Revisión por Dirección. \n",nuevoManual)
        };
        List<EvaluacionDesemManual> evaluacionDesemManualList = new ArrayList<>(Arrays.asList(evaluacionDesemManuals));
        evaluacionDesemManualRepository.saveAll(evaluacionDesemManualList);

        //tabla de EVALUACIÓN DEL DESEMPEÑO
        TablaEvaluacionDesempenoManual[] tablaEvaluacionDesempenoManuals = {
                new TablaEvaluacionDesempenoManual(null,
                        "Conformidad del\n" +
                                "Producto/servicio\n",
                        "Gráficos producto\n" +
                                "No Conforme\n",
                        "Cada producción\n" +
                                "y entrega al cliente\n",
                        "Diario, semanal, mensual,\n" +
                                "Revisión Gerencial.\n",nuevoManual),
                new TablaEvaluacionDesempenoManual(null,
                        "Grado de Satisfacción\n" +
                                "del cliente\n",
                        "Encuestas ",
                        "Quincenal/Mensual",
                        "Junta de Revisión Gerencial",nuevoManual),
                new TablaEvaluacionDesempenoManual(null,
                        "Conformidad del SGC",
                        "Auditorías internas",
                        "Semestral",
                        "En la revisión al SGC\n" +
                                "y Revisión Gerencial\n",nuevoManual),
                new TablaEvaluacionDesempenoManual(null,
                        "Desempeño de \n" +
                                "los procesos\n",
                        "Indicadores de desempeño en los procesos",
                        "Mensualmente",
                        "En la revisión al SGC\n" +
                                "y Revisión Gerencial\n",nuevoManual),
                new TablaEvaluacionDesempenoManual(null,
                        "Desempeño de\n" +
                                "los proveedores\n",
                        "En cada entrega \n" +
                                "o servicio\n",
                        "Mensual",
                        "En la revisión al SGC",nuevoManual)
        };
        List<TablaEvaluacionDesempenoManual> tablaEvaluacionDesempenoManualList = new ArrayList<>(Arrays.asList(tablaEvaluacionDesempenoManuals));
        tablaEvaluacionDesempenoManualRepository.saveAll(tablaEvaluacionDesempenoManualList);


        //MEJORA
        MejoraManual[] mejoraManuals = {
                new MejoraManual(null,"Generalidades","Determinar y seleccionar las oportunidades de mejora e implementar acción necesaria para: \n" +
                        "-\tCumplir los requisitos y aumentar la satisfacción del cliente.\n" +
                        "-\tMejorar el desempeño de los procesos.\n" +
                        "-\tPrevenir o reducir efectos no deseado.\n" +
                        "-\tMejorar desempeño y eficacia del SGC.\n" +
                        "Proceso de Mejora Continua.\n",nuevoManual),
                new MejoraManual(null,"No conformidad y acción correctiva","Cuando ocurra una no conformidad, incluidas las quejas, la organización reacciona ante la no conformidad y cuando sea aplicable, evalúa la necesidad de acciones para eliminar las causas de la no conformidad, con el fin de que no vuelva a ocurrir ni ocurra en otra parte, mediante:\n" +
                        "-\tImplementar cualquier acción necesaria.\n" +
                        "-\tRevisar la eficacia de cualquier acción correctiva tomada.\n" +
                        "-\tSi fuera necesario, actualizar los riesgos y oportunidades determinados durante la planificación.\n" +
                        "-\tSí fuera necesario hacer cambios al sistema de gestión de la calidad, generando evidencia de los cambios realizados a nivel del SGC. \n" +
                        "Proceso de Producto No Conforme.\n" +
                        "Proceso de Acciones Correctivas.\n",nuevoManual),
                new MejoraManual(null,"Mejora continua","Mejorar continuamente la conveniencia, adecuación y eficacia del SGC. Se definen entre otros aspectos a partir de:\n" +
                        "-\tAnálisis de Riesgo y oportunidades.\n" +
                        "-\tAmbiente en el trabajo. \n" +
                        "-\tProcesos del SGC.\n" +
                        "-\tBSC (Análisis de partes interesadas).\n" +
                        "Formato de Mejora Continua.\n",nuevoManual)
        };
        List<MejoraManual> mejoraManualList = new ArrayList<>(Arrays.asList(mejoraManuals));
        mejoraManualRepository.saveAll(mejoraManualList);


        // Array con OperacionesManual predefinidas
        //OperacionManual[] operacionesPredefinidas = {
        //        new OperacionManual(null, "Operacion 1", "Descripción de la Operacion 1", nuevoManual),
        //        new OperacionManual(null, "Operacion 2", "Descripción de la Operacion 2", nuevoManual),
        //        new OperacionManual(null, "Operacion 3", "Descripción de la Operacion 3", nuevoManual)
        //};

        //List<OperacionManual> operacionesList = new ArrayList<>(Arrays.asList(operacionesPredefinidas));
        //operacionManualRepository.saveAll(operacionesList);



        return nuevoManual;
    }

    @Override
    public ManualCalidadDTO updateManualC(Long id, ManualCalidadDTO manualCalidadDTO) {
        Optional<ManualCalidad> optionalManualCalidad = manualCalidadRepository.findById(id);
        if (optionalManualCalidad.isPresent()) {
            ManualCalidad existingManualCalidad = optionalManualCalidad.get();

            // Actualizar los campos individuales
            existingManualCalidad.setFechaEmision(manualCalidadDTO.getFechaEmision());
            existingManualCalidad.setFechaRevision(manualCalidadDTO.getFechaRevision());
            existingManualCalidad.setNoRevision(manualCalidadDTO.getNoRevision());
            existingManualCalidad.setCoDocumento(manualCalidadDTO.getCoDocumento());
            existingManualCalidad.setCoPie(manualCalidadDTO.getCoPie());
            //manualCalidad.setIdManualCalidad(id);

            return mapper.toDTOManualC(manualCalidadRepository.save(existingManualCalidad));
        } else {
            return null;
        }
    }

    @Override
    public void deleteByIdManualC(Long id) {
        manualCalidadRepository.deleteById(id);
    }

    @Override
    public void eleminartodo() {
        for (ManualCalidad manualCalidad : manualCalidadRepository.findAll()){
            manualCalidadRepository.deleteById(manualCalidad.getIdManualCalidad());
        }


    }
}
