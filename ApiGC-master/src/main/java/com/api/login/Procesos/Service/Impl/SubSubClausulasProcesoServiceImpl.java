package com.api.login.Procesos.Service.Impl;

import com.api.login.Procesos.Dao.SubSubClausulasProcesoDao;
import com.api.login.Procesos.Pojo.SubSubClausulasProceso;
import com.api.login.Procesos.Service.SubSubClausulasProcesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SubSubClausulasProcesoServiceImpl implements SubSubClausulasProcesoService {

    @Autowired
    private SubSubClausulasProcesoDao subSubClausulasProcesoRepository;

    @Override
    public List<SubSubClausulasProceso> findAll() {
        return subSubClausulasProcesoRepository.findAll();
    }

    @Override
    public SubSubClausulasProceso findById(Long id) {
        Optional<SubSubClausulasProceso> optional = subSubClausulasProcesoRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<SubSubClausulasProceso> findBySubPunto(Long subpunto) {
        return subSubClausulasProcesoRepository.findBySubClausulasProcesoIdSubClausulasProceso(subpunto);
    }

    @Override
    public SubSubClausulasProceso save(SubSubClausulasProceso subSubClausulasProceso) {
        return subSubClausulasProcesoRepository.save(subSubClausulasProceso);
    }

    @Override
    public SubSubClausulasProceso update(Long id, SubSubClausulasProceso subSubClausulasProceso) {
        Optional<SubSubClausulasProceso> optional = subSubClausulasProcesoRepository.findById(id);
        if (optional.isPresent()) {
            subSubClausulasProceso.setIdSubSubClausulasProceso(id);
            return subSubClausulasProcesoRepository.save(subSubClausulasProceso);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        subSubClausulasProcesoRepository.deleteById(id);
    }
}

