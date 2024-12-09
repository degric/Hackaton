package com.api.login.Documentos.MinutaDeReunion.Repository;

import com.api.login.Documentos.MinutaDeReunion.Pojo.MinutaReunion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MinutaReunionRepository extends JpaRepository<MinutaReunion, Long> {
}

