package com.briefing_bingo.bingo;

import com.briefing_bingo.bingo.phrases.PhraseService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("")
public class MainController {

    @Autowired
    private PhraseService phraseService;

    @GetMapping("/")
    public String index() {
        return "index.jsp";
    }
}