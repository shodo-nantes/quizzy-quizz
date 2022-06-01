package io.shodo.quizzyquizz.infra.providers;

import io.shodo.quizzyquizz.domain.Question;
import io.shodo.quizzyquizz.domain.Question.QuestionType;
import io.shodo.quizzyquizz.infra.adapters.TheMovieDBAnswersProvider;
import io.shodo.quizzyquizz.infra.rest.Answer;
import io.shodo.quizzyquizz.infra.rest.Answers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TheMovieDBAnswersProviderTest {

    private final TheMovieDBAnswersProvider theMovieDBAnswersProvider = new TheMovieDBAnswersProvider(new FakeMovieDBService());

    @Test
    void should_answer_list_of_movies_when_calling_getAnswersFor_with_a_question_of_type_MOVIES_THE_ACTOR_PLAYED_IN() {
        Answers answers = theMovieDBAnswersProvider.getAnswersFor(new Question("toto", QuestionType.MOVIES_THE_ACTOR_PLAYED_IN));
        Answers expectedAnswers = new Answers(
                List.of(
                        new Answer("title:' titre 1', original title: 'title 1'"),
                        new Answer("title:' titre 2', original title: 'title 2'")
                ));
        assertThat(answers).isEqualTo(expectedAnswers);
    }

    @Test
    void should_answer_list_of_movies_when_calling_getAnswersFor_with_a_question_of_type_ACTORS_THE_ACTOR_PLAYED_WITH() {


    }

}