package com.api.login.dao;

import com.api.login.pojo.LisDisDocumentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LisDisDocumentosDao extends JpaRepository<LisDisDocumentos, Integer> {
}
