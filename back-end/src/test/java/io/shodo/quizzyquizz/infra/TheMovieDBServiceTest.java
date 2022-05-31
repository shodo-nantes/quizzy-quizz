package io.shodo.quizzyquizz.infra;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TheMovieDBServiceTest {
    TheMovieDBService theMovieDBService = new TheMovieDBService(new FakeTheMovieDBClient());

    @Test
    void getActor_should_return_the_actor_id() {
        Long id = theMovieDBService.getActorId("test");
        Long expectedId = 1L;
        assertThat(id).isEqualTo(expectedId);
    }

    @Test
    void getMovieCredits_should_return_a_list_of_movies() {
        List<Movie> movies = theMovieDBService.getMovieCredits(123L);
        List<Movie> expectedMovies = List.of(new Movie("title 1", "original title 1"),
                new Movie("title 2", "original title 2"));
        assertThat(movies).isEqualTo(expectedMovies);
    }

    @Test
    void getMovieTheActorPlayedIn_should_return_a_list_of_movies_associated_with_the_actor() {
        List<Movie> movies = theMovieDBService.getMovieTheActorPlayedIn("test");
        List<Movie> expectedMovies = List.of(new Movie("title 3", "original title 3"),
                new Movie("title 4", "original title 4"));
        assertThat(movies).isEqualTo(expectedMovies);
    }

}
