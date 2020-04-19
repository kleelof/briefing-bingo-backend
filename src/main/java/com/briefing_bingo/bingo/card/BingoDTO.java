package com.briefing_bingo.bingo.card;

import java.util.List;

import lombok.Data;

@Data
public class BingoDTO {

    private String playId;
    private List<Integer> checkedPhraseIDs;
}