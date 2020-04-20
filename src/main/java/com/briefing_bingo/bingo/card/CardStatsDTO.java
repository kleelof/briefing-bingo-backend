package com.briefing_bingo.bingo.card;

import java.util.ArrayList;
import java.util.Collection;


import lombok.Data;

@Data
public class CardStatsDTO {

    public Integer numberOfCardsIssued;
    public Integer numberOfBingos;
    public Integer numberOfShares;
    public Collection<Card> cards = new ArrayList<>();

    public CardStatsDTO(Integer numberOfCardsIssued, Integer numberOfBingos, Integer numberOfShares) {
        this.numberOfCardsIssued = numberOfCardsIssued;
        this.numberOfBingos = numberOfBingos;
        this.numberOfShares = numberOfShares;
    }
}