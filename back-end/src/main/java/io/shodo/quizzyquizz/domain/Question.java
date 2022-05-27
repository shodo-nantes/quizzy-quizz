package io.shodo.quizzyquizz.domain;

import java.util.List;

public class Question {

    final String actor;
    final List<String> answers;
    final QuestionType type;
    final String label;

    public Question(String actor, List<String> answers, QuestionType type) {
        this.actor = actor;
        this.answers = answers;
        this.type = type;
        this.label = this.createLabel(actor, type);
    }

    private String createLabel(String actor, QuestionType type) {
        return switch (type) {
            case MOVIES_THE_ACTOR_PLAYED_IN -> String.format("In which movie did %s play?", actor);
            case ACTORS_THE_ACTOR_PLAYED_WITH -> String.format("With which actors did %s play?", actor);
        };

    }

    public List<String> answers() {
        return this.answers;
    }

    public QuestionType getType() {
        return type;
    }

    public enum QuestionType {
        MOVIES_THE_ACTOR_PLAYED_IN,
        ACTORS_THE_ACTOR_PLAYED_WITH
    }

    @Override
    public String toString() {
        return "Question{" +
                "actor='" + actor + '\'' +
                ", answers=" + answers +
                ", type=" + type +
                ", answer='" + label + '\'' +
                '}';
    }
}
