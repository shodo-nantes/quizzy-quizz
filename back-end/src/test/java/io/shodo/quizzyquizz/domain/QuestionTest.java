package io.shodo.quizzyquizz.domain;

import io.shodo.quizzyquizz.infra.TheMovieDBService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class QuestionTest {

    @Autowired
    private TheMovieDBService theMovieDBServiceMock;

    @Test
    void when_a_question_is_created_with_type_MOVIES_THE_ACTOR_PLAYED_IN_the_label_is_created_accordingly() {
        assertThat(Questions.getInstance().getQuestions().get(0).label).isEqualTo("In which movie did Charlize Theron play?");
    }

    @Test
    void when_a_question_is_created_with_type_ACTORS_THE_ACTOR_PLAYED_WITH_the_label_is_created_accordingly() {
        assertThat(Questions.getInstance().getQuestions().get(2).label).isEqualTo("With which actors did Brad Pitt play?");
    }

//    @Test //TODO create a question test and mock the call?
//    void when_creating_a_new_question_with_type_MOVIES_THE_ACTOR_PLAYED_IN_theMovieDB_api_is_called(){
////        List<String> answers = Question("answer", "type").answers();
////        assertThat(answers).isNotEmpty();
//        List<Movie> movieList = List.of(new Movie("First Title", "First Original Title"), new Movie("Second Title", "Second Original Title"));
//        when(theMovieDBServiceMock.getMovieCredits(any(Long.class))).thenReturn(movieList);
//
//
//    }
}
