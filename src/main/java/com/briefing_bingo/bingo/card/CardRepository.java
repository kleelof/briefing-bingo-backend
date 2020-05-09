package com.briefing_bingo.bingo.card;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CardRepository extends JpaRepository<Card, Long> {

    @Query("SELECT COUNT(c) > 0 FROM Card c WHERE c.playId = ?1")
    public boolean confirmPlayId(String playId);

    @Query("FROM Card c WHERE c.playId = ?1")
    public Optional<Card> findCardByPlayId(String playId);

    @Query("SELECT COUNT(c) FROM Card c WHERE c.hasBingo = TRUE")
    public Integer getBingoCount();

    @Query("SELECT COUNT(c) FROM Card c")
    public Integer getNumberOfCardsIssued();

    @Query("SELECT COUNT(c) FROM Card c WHERE c.shared = TRUE")
    public Integer getSharedCount();

    @Query ("SELECT c FROM Card c WHERE c.createdAt >= ?1 AND c.createdAt <= ?2 ORDER BY c.createdAt")
    public List<Card> pullByDateRange(Date startDate, Date endDate);

    //public List<Card> findAllByCreatedAtGreaterThanEqualAndCreatedAtLessThanEqualCaseCreatedAt(Date startDate, Date endDate);
    
    @Modifying
    @Transactional
    @Query("UPDATE Card c SET c.hasBingo = TRUE WHERE c.playId = ?1")
    public void setBingo(String playId);

    @Modifying
    @Transactional
    @Query("UPDATE Card c SET c.shared = TRUE WHERE c.playId = ?1")
    public void setShared(String playId);
}