package io.shodo.quizzyquizz.domain;

public class Question {

    final String actor;
    //TODO liste des réponses dans le Game
    final QuestionType type;
    final String label;

    public Question(String actor, QuestionType type) {
        this.actor = actor;
        this.type = type;
        this.label = this.createLabel(actor, type);
    }


    private String createLabel(String actor, QuestionType type) {
        return switch (type) {
            case MOVIES_THE_ACTOR_PLAYED_IN -> String.format("In which movie did %s play?", actor);
            case ACTORS_THE_ACTOR_PLAYED_WITH -> String.format("With which actors did %s play?", actor);
        };

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
                ", type=" + type +
                ", answer='" + label + '\'' +
                '}';
    }
}
