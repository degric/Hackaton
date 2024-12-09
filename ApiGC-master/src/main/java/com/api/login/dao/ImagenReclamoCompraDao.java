package com.api.login.dao;

import com.api.login.pojo.ImagenReclamoCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagenReclamoCompraDao extends JpaRepository<ImagenReclamoCompra,Integer> {

                            //findByLisDisDocumentosIdLisDisDocumentos(Integer id)
    List<ImagenReclamoCompra> findByReclamoCompraIdReclamoCompra(Integer id);

}
