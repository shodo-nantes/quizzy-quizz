package io.shodo.quizzyquizz.domain;

import io.shodo.quizzyquizz.domain.Question.QuestionType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CreateGameTest {

    private final CreateGame createGame = new CreateGame(new FakeRandomQuestionsProvider(), new FakeAnswersProvider());

    @Test
    void when_a_new_game_is_created_a_question_should_be_created() {
        assertThat(createGame.random().getQuestion()).isEqualTo(Questions.getInstance().getQuestions().get(0));
    }

    @Test
    void when_giving_a_good_answer_to_a_question_the_game_indicate_its_a_correct_answer() {
        assertThat(createGame.random().answer(new PlayerAnswer("Bombshell"))).isTrue();
    }

    @Test
    void when_giving_a_false_answer_to_a_question_the_game_indicate_its_a_correct_answer() {
        assertThat(createGame.random().answer(new PlayerAnswer("Astérix et Obélix : Mission Cléopâtre"))).isFalse();
    }

    @Test
    void when_creating_a_new_game_with_an_actor_and_a_question_type_the_associated_questions_should_be_created() {
        String actor = "Brad Pitt";
        QuestionType questionType = QuestionType.MOVIES_THE_ACTOR_PLAYED_IN;
        String label = new Question(actor, questionType).label;
        assertThat(createGame.fromActorAndQuestionType(actor, questionType).getQuestion().label).isEqualTo(label);
    }


}
