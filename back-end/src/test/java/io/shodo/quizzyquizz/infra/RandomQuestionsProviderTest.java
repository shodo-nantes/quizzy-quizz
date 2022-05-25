package io.shodo.quizzyquizz.infra;

import io.shodo.quizzyquizz.domain.Question;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;


class RandomQuestionsProviderTest {

    private final RandomQuestionsProvider randomQuestionsProvider = new RandomQuestionsProvider(new Random(1L));

    @Test
    void should_return_random_question() {
        var questions = List.of(randomQuestionsProvider.getRandomQuestion(), randomQuestionsProvider.getRandomQuestion());
         assertThat(questions).containsExactly(Questions.getInstance().getQuestions().get(0), Questions.getInstance().getQuestions().get(1));
    }

    //TODO ce test doit il être dans cette classe de test ou dans une classe de test spécifique à Question ? Les classes métiers doivent elles être testées directement?
    @Test
    void should_the_question_returned_have_a_type() {
        Question question = randomQuestionsProvider.getRandomQuestion();
        assertThat(question.getType()).isEqualTo(Question.QuestionType.MOVIES_THE_ACTOR_PLAYED_IN);
    }
}