package com.api.login.FilosofiaOrganizacional.Service.Impl;

import com.api.login.FilosofiaOrganizacional.pojo.Valores;
import com.api.login.FilosofiaOrganizacional.Repository.ValoresRepository;
import com.api.login.FilosofiaOrganizacional.Service.ValoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ValoresServiceImpl implements ValoresService {

    @Autowired
    private ValoresRepository valoresRepository;

    @Override
    public List<Valores> findAll() {
        return valoresRepository.findAll();
    }

    @Override
    public Valores findById(Integer id) {
        Optional<Valores> optionalValores = valoresRepository.findById(id);
        return optionalValores.orElse(null);
    }

    @Override
    public Valores save(Valores valores) {
        return valoresRepository.save(valores);
    }

    @Override
    public Valores update(Integer id, Valores valores) {
        Optional<Valores> optionalValores = valoresRepository.findById(id);
        if (optionalValores.isPresent()) {
            valores.setIdValores(id);
            return valoresRepository.save(valores);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        valoresRepository.deleteById(id);
    }

    @Override
    public List<Valores> findByFecha(LocalDate fecha) {
        return valoresRepository.findByFecha(fecha);
    }
}

