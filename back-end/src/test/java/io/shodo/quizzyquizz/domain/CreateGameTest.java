package io.shodo.quizzyquizz.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CreateGameTest {

    private final CreateGame createGame = new CreateGame(new FakeRandomQuestionsProvider(), new FakeAnswersProvider());

    @Test
    void when_a_new_game_is_created_a_question_should_be_returned() {
        assertThat(createGame.random().getQuestion()).isEqualTo(Questions.getInstance().getQuestions().get(0));
    }

    @Test
    void when_giving_a_good_answer_to_a_question_the_game_indicate_its_a_correct_answer() {
        assertThat(createGame.random().answer("Bombshell")).isTrue();
    }

    @Test
    void when_giving_a_false_answer_to_a_question_the_game_indicate_its_a_correct_answer() {
        assertThat(createGame.random().answer("Astérix et Obélix : Mission Cléopâtre")).isFalse();
    }


}
