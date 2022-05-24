package io.shodo.quizzyquizz.domain;

import java.util.ArrayList;
import java.util.List;

import static io.shodo.quizzyquizz.domain.Question.QuestionType.MOVIES_THE_ACTOR_PLAYED_IN;

public enum Question {
    LIST_CHARLIZE_THERON_MOVIES("Charlize Theron",
            new ArrayList<>(
                    List.of("Bombshell", "The Addams Family", "Atomic Blonde")
            ), MOVIES_THE_ACTOR_PLAYED_IN
    ),
    LIST_THE_ROCK_MOVIES("The Rock",
            new ArrayList<>(
                    List.of("Fast & Furious 6", "Furious 7", "Jumanji: Welcome to the Jungle")
            ), MOVIES_THE_ACTOR_PLAYED_IN
    ),

    LIST_BRAD_PITT_ACTING_PARTNER("Brad Pitt",
            new ArrayList<>(
                    List.of("Leonardo DiCaprio", "Margot Robbie", "Helena Bonham Carter")
            ), QuestionType.ACTORS_THE_ACTOR_PLAYED_WITH
    );
    final String actor;
    final List<String> answers;
    final QuestionType type;
    final String label;

    Question(String actor, List<String> answers, QuestionType type) {
        this.actor = actor;
        this.answers = answers;
        this.type = type;
        this.label = this.createLabel(actor, type);
    }

    private String createLabel(String actor, QuestionType type) {
        return switch (type) {
            case MOVIES_THE_ACTOR_PLAYED_IN -> String.format("In which movie did %s played?", actor);
            case ACTORS_THE_ACTOR_PLAYED_WITH -> String.format("With which actors did %s play?", actor);
            default -> null;
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
}
