package io.shodo.quizzyquizz.domain;

import java.util.List;

public record Answers(List<ValidAnswer> values) {
    public boolean contains(PlayerAnswer playerAnswer) {
        return this.values.stream().anyMatch(it -> it.isValid(playerAnswer));
    }
}
