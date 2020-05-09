package com.briefing_bingo.bingo.card;

import java.util.ArrayList;
import java.util.List;


import lombok.Data;

@Data
public class CardsDataDTO {
    
    public List<CardsDataDayDTO> days = new ArrayList<CardsDataDayDTO>();
}