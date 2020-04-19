package com.briefing_bingo.bingo.controllers;

import java.util.Optional;

import com.briefing_bingo.bingo.card.Card;
import com.briefing_bingo.bingo.card.CardService;
import com.briefing_bingo.bingo.phrases.Phrase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("")
public class MainController {

    @Autowired
    private CardService cardService;

    @GetMapping("/*")
    public String index() {
        return "frontend.jsp";
    }

    @GetMapping("/bingo/{playId}")
    public ModelAndView displayBingoCard(@PathVariable("playId") String playId) {
        Optional<Card> O = cardService.findCardByPlayId(playId);

        if (O.isPresent()) 
            return new ModelAndView("displayBingoCard.jsp", "card", O.get());
        
        return new ModelAndView("frontend.jsp");
    }

    @GetMapping("/close")
    public String closeShareWindow() {
        return "closeMe.jsp";
    }
    
}