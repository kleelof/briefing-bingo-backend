package com.briefing_bingo.bingo.card;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import com.briefing_bingo.bingo.IntArrayToStringConverter;
import com.briefing_bingo.bingo.phrases.Phrase;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cards")
@Data
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable=false)
    private Date createdAt;

    @ManyToMany(fetch = FetchType.LAZY,
    cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    })
    @JoinTable(
        name="card_phrase",
        joinColumns = @JoinColumn(name = "card_id"),
        inverseJoinColumns = @JoinColumn(name = "phrase_id")
    )
    private Collection<Phrase> phrases = new ArrayList<>();

    @Convert(converter = IntArrayToStringConverter.class)
    private List<Integer> checkedPhraseIDs;

    private Boolean hasBingo;
    private String playId;

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
        this.hasBingo = false;
        this.playId = UUID.randomUUID().toString();
    }
}