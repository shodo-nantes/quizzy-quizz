package io.shodo.quizzyquizz.domain;

public record Movie(String title, String originalTitle) implements Answer {
    @Override
    public boolean isValid(PlayerAnswer playerAnswer) {
        return playerAnswer.equals(new PlayerAnswer("Troy"));
    }
}
