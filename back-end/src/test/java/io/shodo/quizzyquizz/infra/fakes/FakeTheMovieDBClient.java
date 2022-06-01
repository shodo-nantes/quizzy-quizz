package io.shodo.quizzyquizz.infra.fakes;

import io.shodo.quizzyquizz.infra.rest.ActorSearch;
import io.shodo.quizzyquizz.infra.rest.ActorSearch.ActorSearchResult;
import io.shodo.quizzyquizz.infra.rest.Movie;
import io.shodo.quizzyquizz.infra.rest.MovieCredits;
import io.shodo.quizzyquizz.infra.rest.TheMovieDBClient;

import java.util.List;

public class FakeTheMovieDBClient implements TheMovieDBClient {
    @Override
    public MovieCredits getMovieCredits(Long personId, String apiKey, String language) {
        List<Movie> movies;
        // allows to have a different behavior when calling getMovieCredits after calling getActor (ie in getMovieTheActorPlayedIn)
        if (personId == 1L) {
            movies = List.of(new Movie("titre 3", "title 3"),
                    new Movie("titre 4", "title 4"));
        } else {
            movies = List.of(new Movie("titre 1", "title 1"),
                    new Movie("titre 2", "title 2"));
        }
        return new MovieCredits(movies);
    }

    @Override
    public ActorSearch getActor(String actorName, String apiKey, String language) {
        return new ActorSearch(List.of(new ActorSearchResult(1L)));
    }
}
