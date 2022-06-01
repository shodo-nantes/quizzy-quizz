package io.shodo.quizzyquizz.infra.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record MovieCredits(@JsonProperty("cast") List<Movie> cast) {

}
