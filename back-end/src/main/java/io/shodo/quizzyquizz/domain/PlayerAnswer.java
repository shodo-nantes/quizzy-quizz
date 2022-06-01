package io.shodo.quizzyquizz.domain;

public record PlayerAnswer(String value) implements Answer {
    @Override
    public boolean isValid() {
        return false; //TODO Fix this
    }
}
