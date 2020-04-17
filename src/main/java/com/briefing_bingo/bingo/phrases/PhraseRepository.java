package com.briefing_bingo.bingo.phrases;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PhraseRepository extends JpaRepository<Phrase, Long> {

    @Query(value = "SELECT * FROM phrases ORDER BY RAND() LIMIT :count", nativeQuery = true)
    public List<Phrase> getRandomPhrases(@Param("count") Integer count);

    @Modifying
    @Transactional
    @Query("UPDATE Phrase p SET p.count = p.count + 1 WHERE p.id = ?1")
    public void updateCount(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Phrase p SET p.checkedCount = p.checkedCount + ?2 WHERE p.id = ?1")
    public void updateCheckedCount(Long id, int count);
}