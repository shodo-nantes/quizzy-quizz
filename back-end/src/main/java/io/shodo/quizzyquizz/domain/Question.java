package io.shodo.quizzyquizz.domain;

import java.util.ArrayList;
import java.util.List;

public enum Question {
    LIST_CHARLIZE_THERON_MOVIES("In which movie did Charlize Theron played?",
            new ArrayList<>(
                List.of("Bombshell", "The Addams Family", "Atomic Blonde")
            ), QuestionType.MOVIES_THE_ACTOR_PLAYED_IN
    ),
    LIST_THE_ROCK_MOVIES("In which movie did The Rock played?",
            new ArrayList<>(
                List.of("Fast & Furious 6", "Furious 7", "Jumanji: Welcome to the Jungle")
            ), QuestionType.MOVIES_THE_ACTOR_PLAYED_IN
    ),

    LIST_BRAD_PITT_ACTING_PARTNER("With which actors did Brad Pitt played?",
            new ArrayList<>(
                List.of("Leonardo DiCaprio", "Margot Robbie", "Helena Bonham Carter")
        ), QuestionType.ACTORS_THE_ACTOR_PLAYED_WITH
    );
    final String label;
    final List<String> answers;
    final QuestionType type;

    Question(String label, List<String> answers, QuestionType type) {
        this.label = label;
        this.answers = answers;
        this.type = type;
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
