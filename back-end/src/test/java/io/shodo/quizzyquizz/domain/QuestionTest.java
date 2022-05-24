package io.shodo.quizzyquizz.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuestionTest {

    @Test
    void when_a_question_is_created_with_type_MOVIES_THE_ACTOR_PLAYED_IN_the_label_is_created_accordingly() {
        Assertions.assertThat(Question.LIST_CHARLIZE_THERON_MOVIES.label).isEqualTo("In which movie did Charlize Theron played?");
    }

    @Test
    void when_a_question_is_created_with_type_ACTORS_THE_ACTOR_PLAYED_WITH_the_label_is_created_accordingly() {
        Assertions.assertThat(Question.LIST_BRAD_PITT_ACTING_PARTNER.label).isEqualTo("With which actors did Brad Pitt play?");
    }


}
