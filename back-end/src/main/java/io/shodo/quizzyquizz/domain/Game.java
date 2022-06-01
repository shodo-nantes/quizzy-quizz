package io.shodo.quizzyquizz.domain;

import java.util.Objects;
import java.util.UUID;

public final class Game {
    private final Question question;
    private final UUID id;
    private final Answers answers;

    //TODO test domain
    public Game(Question question, Answers answers, UUID uuid) {
        this.question = question;
        this.id = uuid;
        this.answers = answers;
    }

    public boolean answer(String answer) {
        return answers.contains(answer);
    }

    public Question getQuestion() {
        return question;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Game) obj;
        return Objects.equals(this.question, that.question) &&
                Objects.equals(this.id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, id);
    }

    @Override
    public String toString() {
        return "Game[" +
                "question=" + question + ", " +
                "id=" + id + ']';
    }


}
