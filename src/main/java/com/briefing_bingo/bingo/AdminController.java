package com.briefing_bingo.bingo;

import javax.validation.Valid;

import com.briefing_bingo.bingo.phrases.Phrase;
import com.briefing_bingo.bingo.phrases.PhraseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @GetMapping("")
    public String index() {
        return "admin/index.jsp";
    }

    @GetMapping("/phrases")
    public ModelAndView phrases() {
        return new ModelAndView("admin/phrases.jsp", "phrases", this.phraseService.findAll());
    }

    @PostMapping("/addPhrase")
    public ModelAndView addPhrase (@RequestParam("phrase") String phrase, @RequestParam("count") Integer count) {
        if (phrase != ""){
            this.phraseService.save(new Phrase(phrase, count));
        }
        return new ModelAndView("redirect:/admin/phrases");
    }
    
    @GetMapping("/deletePhrase/{id}")
    public String deletePhrase(@PathVariable Long id) {
        this.phraseService.delete(id);
        return "redirect:/admin/phrases";
    }
}