package com.api.login.Documentos.AnalisisFoda.Repository;

import com.api.login.Documentos.AnalisisFoda.Pojo.AnalisisFoda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalisisFodaRepository extends JpaRepository<AnalisisFoda, Long> {
}

