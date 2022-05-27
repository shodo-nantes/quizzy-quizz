package io.shodo.quizzyquizz.domain;

import java.util.Objects;
import java.util.UUID;

public final class Game {
    private final Question question;
    private final UUID id;


    //    private final UUID uuid;
    public Game(Question question) {
        this.question = question;
        this.id = UUID.randomUUID(); //TODO question : on est d'accord sur le fait qu'on peut pas garder un record si on fait ça ?
    }

    public boolean answer(String answer) {
        return this.getQuestion().answers().contains(answer);
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
