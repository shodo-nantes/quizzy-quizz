package io.shodo.quizzyquizz.infra;

import com.fasterxml.jackson.annotation.JsonProperty;

public record QuestionResult(@JsonProperty boolean result) {
}
