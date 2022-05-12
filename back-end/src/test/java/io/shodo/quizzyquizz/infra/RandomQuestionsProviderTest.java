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
        assertThat(questions).containsExactly(Question.LIST_CHARLIZE_THERON_MOVIES, Question.LIST_THE_ROCK_MOVIES);
    }

}