package io.shodo.quizzyquizz.infra;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Answer(@JsonProperty String answer) {
}
