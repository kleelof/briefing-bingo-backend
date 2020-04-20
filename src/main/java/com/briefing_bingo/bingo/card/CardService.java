package com.briefing_bingo.bingo.card;

import java.util.List;
import java.util.Optional;

import com.briefing_bingo.bingo.phrases.Phrase;
import com.briefing_bingo.bingo.phrases.PhraseService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    @Autowired
    private CardRepository repository;
    @Autowired
    private PhraseService phraseService;

    private ModelMapper modelMapper = new ModelMapper();

    public CardDTO convertToDto(Card card) {
        return this.modelMapper.map(card, CardDTO.class);
    }

    public Card convertToEntity(CardDTO DTO) {
        return this.modelMapper.map(DTO, Card.class);
    }

    public Card createCard() {
        Card card = this.repository.save(new Card());

        List<Phrase> phrases = phraseService.getRandomPhrases(24);
        phrases.forEach(phrase -> card.getPhrases().add(phrase));

        this.repository.save(card);
        return card;
    }

    public Boolean confirmPlayId(String playId) {
        return this.repository.confirmPlayId(playId);
    }

    public List<Card> findAll() {
        return this.repository.findAll();
    }
    
    public Optional<Card> findCardByPlayId(String playId) {
        return this.repository.findCardByPlayId(playId);
    }

    public void delete(Long id) {
        Optional<Card> O = this.repository.findById(id);

        if (O.isPresent()) {
            this.repository.delete(O.get());
        }
    }

    public CardStatsDTO getStats() {
        return new CardStatsDTO(this.repository.getNumberOfCardsIssued(), this.repository.getBingoCount(), this.repository.getSharedCount());
    }

    public Card save(Card card) {
        return this.repository.save(card);
    }

    public void setBingo(String playId, List<Integer> checkedPhraseIDs) {

        Optional<Card> O = this.repository.findCardByPlayId(playId);
        if (O.isPresent()) {
            Card card = O.get();
            card.setHasBingo(true);
            card.setCheckedPhraseIDs(checkedPhraseIDs);
            this.repository.save(card);
        }
    }

    public void setShared(String playId) {
        this.repository.setShared(playId);
    }
}