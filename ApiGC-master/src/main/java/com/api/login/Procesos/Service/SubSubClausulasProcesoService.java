package com.api.login.Procesos.Service;

import com.api.login.Procesos.Pojo.SubSubClausulasProceso;

import java.util.List;

public interface SubSubClausulasProcesoService {

    List<SubSubClausulasProceso> findAll();

    SubSubClausulasProceso findById(Long id);

    List<SubSubClausulasProceso> findBySubPunto(Long subpunto);

    SubSubClausulasProceso save(SubSubClausulasProceso subSubClausulasProceso);

    SubSubClausulasProceso update(Long id, SubSubClausulasProceso subSubClausulasProceso);

    void deleteById(Long id);

}
