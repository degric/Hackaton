package com.api.login.Documentos.BalanceScoreCard.Repository;

import com.api.login.Documentos.BalanceScoreCard.Pojo.BalanceSCPrespectiva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BalanceSCPrespectivaRepository extends JpaRepository<BalanceSCPrespectiva, Long> {
    List<BalanceSCPrespectiva> findByBalanceScoreCard_IdBalanceScoreCard(Long idBalanceScoreCard);
}
