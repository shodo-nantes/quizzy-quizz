package io.shodo.quizzyquizz.infra;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record MovieCredits(@JsonProperty("cast") List<Movie> cast) {

}
