package com.api.login.Documentos.BalanceScoreCard.Repository;

import com.api.login.Documentos.BalanceScoreCard.Pojo.PartesInteresadas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartesInteresadasRepository extends JpaRepository<PartesInteresadas, Long> {
    List<PartesInteresadas> findByBalanceSCPrespectiva_IdBalanceSCPrespectiva(Long idBalanceSCPrespectiva);
}

