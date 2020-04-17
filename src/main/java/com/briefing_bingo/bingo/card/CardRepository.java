package com.briefing_bingo.bingo.card;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CardRepository extends JpaRepository<Card, Long> {

    @Query("SELECT COUNT(c) > 0 FROM Card c WHERE c.playId = ?1")
    public boolean confirmPlayId(String playId);

    @Query("FROM Card c WHERE c.playId = ?1")
    public Card findCardByPlayId(String playId);
    
    @Modifying
    @Transactional
    @Query("UPDATE Card c SET c.hasBingo = TRUE WHERE c.playId = ?1")
    public void setBingo(String playId);
}