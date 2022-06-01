package io.shodo.quizzyquizz.domain;

import java.util.List;

public record Answers(List<Answer> values) {
    public boolean contains(String label) {
        return this.values.contains(new PlayerAnswer(label));
    }
}
