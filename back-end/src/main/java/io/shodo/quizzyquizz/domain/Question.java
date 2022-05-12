package io.shodo.quizzyquizz.domain;

public enum Question {
    LIST_CHARLIZE_THERON_MOVIES("In which movie did Charlize Theron played?"),
    LIST_THE_ROCK_MOVIES("In which movie did The Rock played?"),
    LIST_BRAD_PITT_ACTING_PARTNER("With which actors did Brad Pitt played?");
    final String label;

    Question(String label) {
        this.label = label;
    }
}
