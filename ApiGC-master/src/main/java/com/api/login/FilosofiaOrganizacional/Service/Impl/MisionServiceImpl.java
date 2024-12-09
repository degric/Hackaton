package com.api.login.FilosofiaOrganizacional.Service.Impl;

import com.api.login.FilosofiaOrganizacional.pojo.Mision;
import com.api.login.FilosofiaOrganizacional.Repository.MisionRepository;
import com.api.login.FilosofiaOrganizacional.Service.MisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

@Service
public class MisionServiceImpl implements MisionService {

    @Autowired
    private MisionRepository misionRepository;

    @Override
    public List<Mision> findAll() {
        return misionRepository.findAll();
    }

    @Override
    public Mision findById(Integer id) {
        Optional<Mision> optionalMision = misionRepository.findById(id);
        return optionalMision.orElse(null);
    }

    @Override
    public Mision save(Mision mision) {
        return misionRepository.save(mision);
    }

    @Override
    public Mision update(Integer id, Mision mision) {
        Optional<Mision> optionalMision = misionRepository.findById(id);
        if (optionalMision.isPresent()) {
            mision.setIdMision(id);
            return misionRepository.save(mision);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        misionRepository.deleteById(id);
    }

    @Override
    public List<Mision> findByFecha(LocalDate fecha) {
        return misionRepository.findByFecha(fecha);
    }
}

