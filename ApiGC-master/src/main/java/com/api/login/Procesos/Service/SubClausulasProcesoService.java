package com.api.login.Procesos.Service;

import com.api.login.Procesos.Pojo.SubClausulasProceso;

import java.util.List;

public interface SubClausulasProcesoService {

    List<SubClausulasProceso> findAll();

    SubClausulasProceso findById(Long id);

    List<SubClausulasProceso> findByclausula(Long id);

    SubClausulasProceso save(SubClausulasProceso subClausulasProceso);

    SubClausulasProceso update(Long id, SubClausulasProceso subClausulasProceso);

    void deleteById(Long id);

}
