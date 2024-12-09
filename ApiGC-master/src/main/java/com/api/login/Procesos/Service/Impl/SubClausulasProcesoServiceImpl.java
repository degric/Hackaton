package com.api.login.Procesos.Service.Impl;

import com.api.login.Procesos.Dao.SubClausulasProcesoDao;
import com.api.login.Procesos.Dao.SubSubClausulasProcesoDao;
import com.api.login.Procesos.Pojo.SubClausulasProceso;
import com.api.login.Procesos.Service.SubClausulasProcesoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SubClausulasProcesoServiceImpl implements SubClausulasProcesoService {

    @Autowired
    private SubClausulasProcesoDao subClausulasProcesoRepository;

    @Autowired
    private SubSubClausulasProcesoDao subSubClausulasProcesoDao;

    @Override
    public List<SubClausulasProceso> findAll() {
        return subClausulasProcesoRepository.findAll();
    }

    @Override
    public SubClausulasProceso findById(Long id) {
        Optional<SubClausulasProceso> optional = subClausulasProcesoRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<SubClausulasProceso> findByclausula(Long id) {
        return subClausulasProcesoRepository.findByDesarrolloProcesoIdDesarrolloProceso(id);
    }

    @Override
    public SubClausulasProceso save(SubClausulasProceso subClausulasProceso) {
        return subClausulasProcesoRepository.save(subClausulasProceso);
    }

    @Transactional
    @Override
    public SubClausulasProceso update(Long id, SubClausulasProceso subClausulasProceso) {
        Optional<SubClausulasProceso> optional = subClausulasProcesoRepository.findById(id);
        if (optional.isPresent()) {
            subClausulasProceso.setSubSubClausulasProceso(subSubClausulasProcesoDao.findBySubClausulasProcesoIdSubClausulasProceso(id));
            subClausulasProceso.setIdSubClausulasProceso(id);
            return subClausulasProcesoRepository.save(subClausulasProceso);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        subClausulasProcesoRepository.deleteById(id);
    }
}

