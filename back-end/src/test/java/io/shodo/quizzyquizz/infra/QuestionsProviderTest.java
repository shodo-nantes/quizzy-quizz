package io.shodo.quizzyquizz.infra;

import io.shodo.quizzyquizz.domain.Question;
import io.shodo.quizzyquizz.domain.Question.QuestionType;
import io.shodo.quizzyquizz.domain.Questions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;


class QuestionsProviderTest {

    private final QuestionsProvider questionsProvider = new QuestionsProvider(new Random(1L));

    @Test
    void should_return_random_question() {
        var questions = List.of(questionsProvider.getRandomQuestion(), questionsProvider.getRandomQuestion());
        assertThat(questions).containsExactly(Questions.getInstance().getQuestions().get(0), Questions.getInstance().getQuestions().get(1));
    }

    //TODO ce test doit il être dans cette classe de test ou dans une classe de test spécifique à Question ? Les classes métiers doivent elles être testées directement?
    @Test
    void should_the_question_returned_have_a_type() {
        Question question = questionsProvider.getRandomQuestion();
        assertThat(question.getType()).isEqualTo(QuestionType.MOVIES_THE_ACTOR_PLAYED_IN);
    }

    @Test
    void should_return_question_from_actor_and_type() {
        String actor = "Brad Pitt";
        QuestionType questionType = QuestionType.MOVIES_THE_ACTOR_PLAYED_IN;
        String expectedLabel = String.format(questionType.getLabel(), actor);

        Question question = questionsProvider.getQuestionFromActorAndType(actor, questionType);
        assertThat(question.getLabel()).isEqualTo(expectedLabel);

    }
}