package io.shodo.quizzyquizz.domain;

import java.util.List;

public record Answers(List<Answer> values) {
    public boolean contains(String answer) {
        return this.values.contains(new Answer(answer));
    }
}
