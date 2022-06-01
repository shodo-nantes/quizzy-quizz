package io.shodo.quizzyquizz.infra.providers;

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


    @Test
    void should_return_question_from_actor_and_type() {
        String actor = "Brad Pitt";
        QuestionType questionType = QuestionType.MOVIES_THE_ACTOR_PLAYED_IN;
        String expectedLabel = String.format(questionType.getLabel(), actor);

        Question question = questionsProvider.getQuestionFromActorAndType(actor, questionType);
        assertThat(question.getLabel()).isEqualTo(expectedLabel);

    }
}