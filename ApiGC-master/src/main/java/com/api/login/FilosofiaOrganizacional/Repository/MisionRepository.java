package com.api.login.FilosofiaOrganizacional.Repository;

import com.api.login.FilosofiaOrganizacional.pojo.Mision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface MisionRepository extends JpaRepository<Mision, Integer> {
    List<Mision> findByFecha(LocalDate fecha);
}
