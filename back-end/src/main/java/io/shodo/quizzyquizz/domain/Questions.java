package io.shodo.quizzyquizz.domain;

import java.util.ArrayList;

import static io.shodo.quizzyquizz.domain.Question.QuestionType.ACTORS_THE_ACTOR_PLAYED_WITH;
import static io.shodo.quizzyquizz.domain.Question.QuestionType.MOVIES_THE_ACTOR_PLAYED_IN;

//TODO should it be in infra or in domain?
//TODO delete usages
public final class Questions {
    private static Questions instance;

    final ArrayList<Question> questions = new ArrayList<>();

    private Questions() {
        this.questions.add(new Question("Charlize Theron", MOVIES_THE_ACTOR_PLAYED_IN));
        this.questions.add(new Question("The Rock", MOVIES_THE_ACTOR_PLAYED_IN));
        this.questions.add(new Question("Brad Pitt", ACTORS_THE_ACTOR_PLAYED_WITH));
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