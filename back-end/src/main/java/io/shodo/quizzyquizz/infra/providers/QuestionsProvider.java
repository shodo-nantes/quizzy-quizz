package io.shodo.quizzyquizz.infra.providers;

import io.shodo.quizzyquizz.domain.Question;
import io.shodo.quizzyquizz.domain.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

@Component
public class QuestionsProvider implements io.shodo.quizzyquizz.domain.QuestionsProvider {

    private final Random random;

    @Autowired
    public QuestionsProvider(@Value("#{new java.util.Random()}") Random random) {
        this.random = random;
    }

    @Override
    public Question getRandomQuestion() {
        ArrayList<Question> questions = Questions.getInstance().getQuestions();
        int randomIndex = random.nextInt(questions.size());
        return questions.get(randomIndex);

    }

    @Override
    public Question getQuestionFromActorAndType(String actor, Question.QuestionType questionType) {
        return new Question(actor, questionType);
    }
}
