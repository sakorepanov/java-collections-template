package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.helper.Direction;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.*;

/**
 * Данный класс обязан использовать StreamApi из функционала Java 8. Функциональность должна быть идентична
 * {@link SimpleTextStatisticsAnalyzer}.
 */
public class StreamApiTextStatisticsAnalyzer implements TextStatisticsAnalyzer {
    @Override
    public int countSumLengthOfWords(String text) {
        return getWords(text)
                .stream()
                .mapToInt(String::length)
                .sum();
    }

    @Override
    public int countNumberOfWords(String text) {
        return getWords(text).size();
    }

    @Override
    public int countNumberOfUniqueWords(String text) {
        return getUniqueWords(text).size();
    }

    @Override
    public List<String> getWords(String text) {
        Stream<String> stream = Arrays.stream(text.split("\\W+"));
        return stream.collect(Collectors.toList());
    }

    @Override
    public Set<String> getUniqueWords(String text) {
        Stream<String> stream = Arrays.stream(text.split("\\W+"));
        return stream.collect(Collectors.toSet());
    }

    @Override
    public Map<String, Integer> countNumberOfWordsRepetitions(String text) {
        return emptyMap();
    }

    @Override
    public List<String> sortWordsByLength(String text, Direction direction) {
        return emptyList();
    }
}
