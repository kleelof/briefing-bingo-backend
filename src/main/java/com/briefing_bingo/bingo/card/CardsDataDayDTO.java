package com.briefing_bingo.bingo.card;

import java.util.ArrayList;
import java.util.Collection;

import lombok.Data;

@Data
public class CardsDataDayDTO {
    
    public String date = "";
    public Integer numberOfCardsIssued = 0;
    public Integer numberOfBingos = 0;
    public Integer numberOfShares = 0;
    public Collection<Card> cards = new ArrayList<>();
}