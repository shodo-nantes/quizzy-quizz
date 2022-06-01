package io.shodo.quizzyquizz.infra.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ActorSearch(@JsonProperty("results") List<ActorSearchResult> results) {
    public record ActorSearchResult(@JsonProperty("id") Long id) {
    }

    public record QuestionResult(@JsonProperty boolean result) {
    }
}

