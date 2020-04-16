package com.briefing_bingo.bingo.phrases;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhraseService {

    @Autowired
    private PhraseRepository repository;

    public void delete(Long id) {
        Optional<Phrase> O = this.repository.findById(id);

        if (O.isPresent()) {
            this.repository.delete(O.get());
        }
    }

    public List<Phrase> findAll() {
        return this.repository.findAll();
    }

    public Phrase save(Phrase phrase) {
        return this.repository.save(phrase);
    }
}