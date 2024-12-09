package com.api.login.dao;

import com.api.login.pojo.TrabajoNoConforme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajoNoConformeDao extends JpaRepository<TrabajoNoConforme, Integer> {
}
