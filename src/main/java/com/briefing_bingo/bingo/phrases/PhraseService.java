package com.briefing_bingo.bingo.phrases;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhraseService {

    @Autowired
    private PhraseRepository repository;

    public void activate(Long id) {
        this.repository.activate(id);
    }
    
    public void delete(Long id) {
        Optional<Phrase> O = this.repository.findById(id);

        if (O.isPresent()) {
            this.repository.delete(O.get());
        }
    }

    public void deactivate(Long id) {
        this.repository.deactivate(id);
    }

    public List<Phrase> findAll() {
        return this.repository.findAll();
    }

    public List<Phrase> findAllAlphabetical() {
        return this.repository.findAllAlphabetical();
    }

    public List<Phrase> getRandomPhrases(Integer count) {
        List<Phrase> phrases = this.repository.getRandomPhrases(count);
        phrases.forEach(phrase -> this.repository.updateCount(phrase.getId()));
        return this.repository.getRandomPhrases(count);
    }

    public Phrase save(Phrase phrase) {
        return this.repository.save(phrase);
    }

    public void setChecked(Long id, Boolean checked) {
        this.repository.updateCheckedCount(id, checked == true ? 1 : -1);
    }

    public void updatePhrase(Long id, String newPhrase) {
        this.repository.updatePhrase(id, newPhrase);
    }
}