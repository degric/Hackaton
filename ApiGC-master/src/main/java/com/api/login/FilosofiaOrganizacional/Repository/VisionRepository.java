package com.api.login.FilosofiaOrganizacional.Repository;

import com.api.login.FilosofiaOrganizacional.pojo.Vision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VisionRepository extends JpaRepository<Vision, Integer> {
    List<Vision> findByFecha(LocalDate fecha);
}

