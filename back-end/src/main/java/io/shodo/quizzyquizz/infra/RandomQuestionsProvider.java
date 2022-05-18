package io.shodo.quizzyquizz.infra;

import io.shodo.quizzyquizz.domain.Question;
import io.shodo.quizzyquizz.domain.QuestionsProvider;

import java.util.Random;

public class RandomQuestionsProvider implements QuestionsProvider {

    private final Random random;

    public RandomQuestionsProvider(Random random) {
        this.random = random;
    }

    @Override
    public Question getRandomQuestion() {
        int randomIndex = random.nextInt(Question.values().length);
        return Question.values()[randomIndex];

    }
}
