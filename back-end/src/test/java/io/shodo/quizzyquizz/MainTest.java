package io.shodo.quizzyquizz;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {

    @Test
    void when_a_new_game_is_created_a_question_should_be_returned() {
        assertThat(new Game("new game").question()).isEqualTo("List the Charlize Theron movies");
    }

    private record Game(String s) {
        private String question() {
            return "List the Charlize Theron movies";
        }
    }
}
