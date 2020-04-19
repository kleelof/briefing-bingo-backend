package com.briefing_bingo.bingo;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Collections;

@Converter
public class IntArrayToStringConverter implements AttributeConverter<List<Integer>,String>{
    @Override
    public String convertToDatabaseColumn(List<Integer> attribute) {
        return attribute == null ? null :StringUtils.collectionToCommaDelimitedString(attribute); // StringUtils.join(attribute,",");
    }

    @Override
    public List<Integer> convertToEntityAttribute(String dbData) {
        /*
        if (StringUtils.isBlank(dbData))
            return Collections.emptyList();
        */

        if (StringUtils.isEmpty(dbData))
            return Collections.emptyList();

        try (Stream<String> stream = Arrays.stream(dbData.split(","))) {
            return stream.map(Integer::parseInt).collect(Collectors.toList());
        }
    }
}