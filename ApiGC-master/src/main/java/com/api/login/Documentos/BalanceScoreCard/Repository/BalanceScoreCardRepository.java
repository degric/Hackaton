package com.api.login.Documentos.BalanceScoreCard.Repository;

import com.api.login.Documentos.BalanceScoreCard.Pojo.BalanceScoreCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceScoreCardRepository extends JpaRepository<BalanceScoreCard, Long> {
}
