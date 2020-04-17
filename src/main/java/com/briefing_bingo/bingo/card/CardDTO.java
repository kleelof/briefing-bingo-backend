package com.briefing_bingo.bingo.card;

import java.util.List;

import com.briefing_bingo.bingo.phrases.Phrase;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
public class CardDTO {

    private String playId;

    @JsonIgnoreProperties("cards")
    private List<Phrase> phrases;
}