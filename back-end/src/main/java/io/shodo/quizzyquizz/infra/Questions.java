package io.shodo.quizzyquizz.infra;

import io.shodo.quizzyquizz.domain.Question;

import java.util.ArrayList;
import java.util.List;

import static io.shodo.quizzyquizz.domain.Question.QuestionType.ACTORS_THE_ACTOR_PLAYED_WITH;
import static io.shodo.quizzyquizz.domain.Question.QuestionType.MOVIES_THE_ACTOR_PLAYED_IN;

//TODO should it be in infra or in domain?
public final class Questions {
    private static Questions instance;

    final ArrayList<Question> questions = new ArrayList<>();

    private Questions() {
        this.questions.add(new Question("Charlize Theron", new ArrayList<>(
                List.of("Bombshell", "The Addams Family", "Atomic Blonde")
        ), MOVIES_THE_ACTOR_PLAYED_IN));
        this.questions.add(new Question("The Rock", new ArrayList<>(
                List.of("Fast & Furious 6", "Furious 7", "Jumanji: Welcome to the Jungle")
        ), MOVIES_THE_ACTOR_PLAYED_IN));
        this.questions.add(new Question("Brad Pitt", new ArrayList<>(
                List.of("Leonardo DiCaprio", "Margot Robbie", "Helena Bonham Carter")
        ), ACTORS_THE_ACTOR_PLAYED_WITH));
    }

    public static Questions getInstance() {
        if (instance == null) {
            instance = new Questions();
        }
        return instance;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }
}