package com.api.login.FilosofiaOrganizacional.Repository;

import com.api.login.FilosofiaOrganizacional.pojo.Valores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ValoresRepository extends JpaRepository<Valores, Integer> {
    List<Valores> findByFecha(LocalDate fecha);
}

