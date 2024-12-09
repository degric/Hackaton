package com.api.login.dao;

import com.api.login.pojo.DocumentosLisDisDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentosLisDisDoDao extends JpaRepository<DocumentosLisDisDo, Integer> {

    List<DocumentosLisDisDo> findByLisDisDocumentosIdLisDisDocumentos(Integer id);

}
