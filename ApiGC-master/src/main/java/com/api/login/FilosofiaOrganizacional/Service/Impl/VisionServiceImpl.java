package com.api.login.FilosofiaOrganizacional.Service.Impl;

import com.api.login.FilosofiaOrganizacional.pojo.Vision;
import com.api.login.FilosofiaOrganizacional.Repository.VisionRepository;
import com.api.login.FilosofiaOrganizacional.Service.VisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VisionServiceImpl implements VisionService {

    @Autowired
    private VisionRepository visionRepository;

    @Override
    public List<Vision> findAll() {
        return visionRepository.findAll();
    }

    @Override
    public Vision findById(Integer id) {
        Optional<Vision> optionalVision = visionRepository.findById(id);
        return optionalVision.orElse(null);
    }

    @Override
    public Vision save(Vision vision) {
        return visionRepository.save(vision);
    }

    @Override
    public Vision update(Integer id, Vision vision) {
        Optional<Vision> optionalVision = visionRepository.findById(id);
        if (optionalVision.isPresent()) {
            vision.setIdVision(id);
            return visionRepository.save(vision);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        visionRepository.deleteById(id);
    }

    @Override
    public List<Vision> findByFecha(LocalDate fecha) {
        return visionRepository.findByFecha(fecha);
    }
}
