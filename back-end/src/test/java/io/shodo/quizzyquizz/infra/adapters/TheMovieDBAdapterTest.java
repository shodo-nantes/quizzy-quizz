package io.shodo.quizzyquizz.infra.adapters;

import io.shodo.quizzyquizz.infra.fakes.FakeTheMovieDBClient;
import io.shodo.quizzyquizz.infra.rest.Movie;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TheMovieDBAdapterTest {
    TheMovieDBAdapter theMovieDBAdapter = new TheMovieDBAdapter(new FakeTheMovieDBClient());

    @Test
    void getActor_should_return_the_actor_id() {
        Long id = theMovieDBAdapter.getActorId("test");
        Long expectedId = 1L;
        assertThat(id).isEqualTo(expectedId);
    }

    @Test
    void getMovieCredits_should_return_a_list_of_movies() {
        List<Movie> movies = theMovieDBAdapter.getMovieCredits(123L);
        List<Movie> expectedMovies = List.of(new Movie("titre 1", "title 1"),
                new Movie("titre 2", "title 2"));
        assertThat(movies).isEqualTo(expectedMovies);
    }

    @Test
    void getMovieTheActorPlayedIn_should_return_a_list_of_movies_associated_with_the_actor() {
        List<Movie> movies = theMovieDBAdapter.getMovieTheActorPlayedIn("test");
        List<Movie> expectedMovies = List.of(new Movie("titre 3", "title 3"),
                new Movie("titre 4", "title 4"));
        assertThat(movies).isEqualTo(expectedMovies);
    }

}
