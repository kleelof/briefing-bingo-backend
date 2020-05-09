package com.briefing_bingo.bingo.controllers;

import javax.websocket.server.PathParam;

import com.briefing_bingo.bingo.card.CardService;
import com.briefing_bingo.bingo.card.CardStatsDTO;
import com.briefing_bingo.bingo.card.CardsDataDTO;
import com.briefing_bingo.bingo.phrases.Phrase;
import com.briefing_bingo.bingo.phrases.PhraseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private PhraseService phraseService;
    @Autowired
    private CardService cardService;

    @GetMapping("")
    public String index() {
        return "admin/index.jsp";
    }

    @PostMapping("/addPhrase")
    public ModelAndView addPhrase (@RequestParam("phrase") String phrase, @RequestParam("count") Integer count) {
        if (phrase != ""){
            this.phraseService.save(new Phrase(phrase, count));
        }
        return new ModelAndView("redirect:/admin/phrases");
    }
    
    @GetMapping("/cards")
    public ModelAndView cards(){
        CardStatsDTO DTO = this.cardService.getStats();
        DTO.cards = this.cardService.findAll();
        return new ModelAndView("admin/cards.jsp", "DTO", DTO );
    }

    @GetMapping("/cardCharts")
    public ModelAndView cardsCharts() throws JsonProcessingException {
        DateTime now = new DateTime();
        DateTime weekAgo = now.minusDays(7);
        CardsDataDTO DTO = this.cardService.getCardsData(weekAgo.toLocalDate(), now.toLocalDate());
        return new ModelAndView("admin/cardChart.jsp", "DTO", new ObjectMapper().writeValueAsString(DTO));
    }

    @GetMapping("/phrase/deactivate/{id}")
    public String deactivatePhrase(@PathVariable Long id) {
        this.phraseService.deactivate(id);
        return "redirect:/admin/phrases";
    }

    @GetMapping("/phrase/activate/{id}")
    public String activatePhrase(@PathVariable Long id) {
        this.phraseService.activate(id);
        return "redirect:/admin/phrases";
    }

    @GetMapping("/phrases")
    public ModelAndView phrases() {
        return new ModelAndView("admin/phrases.jsp", "phrases", this.phraseService.findAllAlphabetical());
    }

    @GetMapping("/phrase/update/{id}")
    public String updatePhrase(@PathVariable("id") Long id, @PathParam("phrase") String phrase) {
        this.phraseService.updatePhrase(id, phrase);
        return "redirect:/admin/phrases";
    }

}