package com.briefing_bingo.bingo.phrases;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    private Integer count;

    @Column(updatable=false)
    private Date createdAt;

    public Phrase(String phrase, Integer count) {
        this.phrase = phrase;
        this.count = count;
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
        if (this.count == null) this.count = 0;
    }
}