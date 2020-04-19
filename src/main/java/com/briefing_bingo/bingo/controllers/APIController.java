package com.briefing_bingo.bingo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.briefing_bingo.bingo.card.BingoDTO;
import com.briefing_bingo.bingo.card.CardDTO;
import com.briefing_bingo.bingo.card.CardService;
import com.briefing_bingo.bingo.phrases.PhraseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
public class APIController {

    @Autowired
    private CardService cardService;
    @Autowired
    private PhraseService phraseService;

    @GetMapping("/getCard")
    public ResponseEntity<?> getCard() {
        CardDTO card = this.cardService.convertToDto(this.cardService.createCard());
        return ResponseEntity.ok().body(card);
    }

    @GetMapping("/phraseChecked/{id}/{playId}")
    public ResponseEntity<?> phraseChecked(@PathVariable("id") Long id, @PathVariable("playId") String playId) {
        if (cardService.confirmPlayId(playId)){
            this.phraseService.setChecked(id, true);
        }
        return ResponseEntity.ok().body("ok");
    }

    @GetMapping("/phraseUnchecked/{id}/{playId}")
    public ResponseEntity<?> phraseUnchecked(@PathVariable("id") Long id, @PathVariable("playId") String playId) {
        if(cardService.confirmPlayId(playId)) {
            this.phraseService.setChecked(id, false);
        }
        return ResponseEntity.ok().body("ok");
    }

    @PostMapping("/setBingo")
    public ResponseEntity<?> setBingo(@RequestBody BingoDTO DTO) {
        this.cardService.setBingo(DTO.getPlayId(), DTO.getCheckedPhraseIDs());
        return ResponseEntity.ok().body("ok");
    }
}