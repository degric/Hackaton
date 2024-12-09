package com.api.login.dao;

import com.api.login.pojo.FirmaLisDisDocumentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FirmaLisDisDocumentosDao extends JpaRepository<FirmaLisDisDocumentos, Integer> {

    List<FirmaLisDisDocumentos> findByLisDisDocumentosIdLisDisDocumentos(Integer id);

}
