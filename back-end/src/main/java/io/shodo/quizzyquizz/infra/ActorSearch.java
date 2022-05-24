package io.shodo.quizzyquizz.infra;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ActorSearch(@JsonProperty("results") List<ActorSearchResult> results) {
    record ActorSearchResult(@JsonProperty("id") Long id) {
    }
}

