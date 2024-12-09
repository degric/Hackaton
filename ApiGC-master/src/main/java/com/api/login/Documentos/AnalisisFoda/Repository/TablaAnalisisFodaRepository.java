package com.api.login.Documentos.AnalisisFoda.Repository;

import com.api.login.Documentos.AnalisisFoda.Pojo.TablaAnalisisFoda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TablaAnalisisFodaRepository extends JpaRepository<TablaAnalisisFoda, Long> {
    List<TablaAnalisisFoda> findByAnalisisFoda_IdAnalisisFoda(Long idAnalisisFoda);  // Método para buscar por idAnalisisFoda
}

