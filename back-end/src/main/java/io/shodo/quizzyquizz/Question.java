package io.shodo.quizzyquizz;

public enum Question {
    LIST_ACTOR_MOVIE("In which movie did this actor/actress played?");
    final String label;

    Question(String label) {
        this.label = label;
    }
}
