package com.briefing_bingo.bingo.phrases;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.briefing_bingo.bingo.card.Card;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "phrases")
@Data
@NoArgsConstructor
public class Phrase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String phrase;

    @JsonIgnore
    private Integer count;

    @Column(updatable=false)
    private Date createdAt;

    @ManyToMany(fetch = FetchType.LAZY,
                cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
                },
                mappedBy = "phrases")
    private Collection<Card> cards;

    @JsonIgnore
    private Integer checkedCount;

    public Phrase(String phrase, Integer count) {
        this.phrase = phrase;
        this.count = count;
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
        if (this.count == null) this.count = 0;
        this.checkedCount = 0;
    }
}