package io.shodo.quizzyquizz.domain;

public record PlayerAnswer(String value) implements Answer {
    @Override
    public boolean isValid(PlayerAnswer playerAnswer) {
        return false; //TODO Fix this Is it necessary to implement Answer ?
    }
}
