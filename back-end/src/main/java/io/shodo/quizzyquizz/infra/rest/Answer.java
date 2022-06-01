package io.shodo.quizzyquizz.infra.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Answer(@JsonProperty String answer) {
}
