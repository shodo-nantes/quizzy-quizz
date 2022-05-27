package io.shodo.quizzyquizz.infra;

import io.shodo.quizzyquizz.domain.Question;
import io.shodo.quizzyquizz.domain.Questions;
import io.shodo.quizzyquizz.domain.QuestionsProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

@Component
public class RandomQuestionsProvider implements QuestionsProvider {

    private final Random random;

    @Autowired
    public RandomQuestionsProvider(@Value("#{new java.util.Random()}") Random random) {
        this.random = random;
    }

    @Override
    public Question getRandomQuestion() {
        ArrayList<Question> questions = Questions.getInstance().getQuestions();
        int randomIndex = random.nextInt(questions.size());
        return questions.get(randomIndex);

    }
}
