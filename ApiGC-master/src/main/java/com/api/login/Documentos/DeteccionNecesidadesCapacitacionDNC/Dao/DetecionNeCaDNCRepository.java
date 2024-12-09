package com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Dao;

import com.api.login.Documentos.DeteccionNecesidadesCapacitacionDNC.Pojo.DetecionNeCaDNC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetecionNeCaDNCRepository extends JpaRepository<DetecionNeCaDNC, Long> {
}
