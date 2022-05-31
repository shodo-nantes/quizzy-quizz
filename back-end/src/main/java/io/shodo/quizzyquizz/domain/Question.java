package io.shodo.quizzyquizz.domain;

public class Question {

    final String actor;
    final QuestionType type;
    final String label;

    public Question(String actor, QuestionType type) {
        this.actor = actor;
        this.type = type;
        this.label = this.createLabel(actor, type);
    }


    private String createLabel(String actor, QuestionType type) {
        return String.format(type.getLabel(), actor);
    }


    public QuestionType getType() {
        return type;
    }

    public String getLabel() {
        return label;
    }

    public String getActor() {
        return actor;
    }

    @Override
    public String toString() {
        return "Question{" +
                "actor='" + actor + '\'' +
                ", type=" + type +
                ", label='" + label + '\'' +
                '}';
    }

    public enum QuestionType {
        MOVIES_THE_ACTOR_PLAYED_IN("In which movie did %s play?"),
        ACTORS_THE_ACTOR_PLAYED_WITH("With which actors did %s play?");

        private final String label;

        QuestionType(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }
}
