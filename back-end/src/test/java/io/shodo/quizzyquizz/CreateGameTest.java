package io.shodo.quizzyquizz;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CreateGameTest {

    private final CreateGame createGame = new CreateGame(new FakeRandomQuestionsProvider());

    @Test
    void when_a_new_game_is_created_a_question_should_be_returned() {
        assertThat(createGame.random().question()).isEqualTo(Question.LIST_ACTOR_MOVIE);
    }

}
