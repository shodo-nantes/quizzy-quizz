package io.shodo.quizzyquizz.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public enum Question {
    LIST_CHARLIZE_THERON_MOVIES("In which movie did Charlize Theron played?",
            new ArrayList<>(
                List.of("Bombshell", "The Addams Family", "Atomic Blonde")
            )
    ),
    LIST_THE_ROCK_MOVIES("In which movie did The Rock played?",
            new ArrayList<>(
                List.of("Fast & Furious 6", "Furious 7", "Jumanji: Welcome to the Jungle")
            )
    ),

    LIST_BRAD_PITT_ACTING_PARTNER("With which actors did Brad Pitt played?",
            new ArrayList<>(
                List.of("Leonardo DiCaprio", "Margot Robbie", "Helena Bonham Carter")
        )
    );
    final String label;
    final List<String> answers;

    Question(String label, List<String> answers) {
        this.label = label;
        this.answers = answers;
    }

    public List<String> answers() {
        return this.answers;
    }
}
