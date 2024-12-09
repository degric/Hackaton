package com.api.login.Documentos.BalanceScoreCard.Repository;

import com.api.login.Documentos.BalanceScoreCard.Pojo.MetricasBSC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MetricasBSCRepository extends JpaRepository<MetricasBSC, Long> {
    List<MetricasBSC> findByBalanceSCPrespectiva_IdBalanceSCPrespectiva(Long idBalanceSCPrespectiva);

    @Query("SELECT DISTINCT m.objetivo FROM MetricasBSC m")
    List<String> findDistinctObjetivos();

    // Consulta para buscar por nombre de objetivo
    List<MetricasBSC> findByObjetivoContainingIgnoreCase(String objetivo);

}
