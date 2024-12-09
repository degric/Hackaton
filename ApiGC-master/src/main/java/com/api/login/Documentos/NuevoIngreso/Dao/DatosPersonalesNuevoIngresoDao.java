package com.api.login.Documentos.NuevoIngreso.Dao;

import com.api.login.Documentos.NuevoIngreso.Pojo.DatosPersonalesNuevoIngreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DatosPersonalesNuevoIngresoDao extends JpaRepository<DatosPersonalesNuevoIngreso, Integer> {

                            //findBySolicitudCotizacionIdSolicitudCotizacion(Integer id)
    Optional<DatosPersonalesNuevoIngreso> findByNuevoIngresoIdNuevoIngreso(Integer integer);
}
