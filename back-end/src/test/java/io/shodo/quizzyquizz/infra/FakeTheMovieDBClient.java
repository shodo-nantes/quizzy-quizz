package io.shodo.quizzyquizz.infra;

import io.shodo.quizzyquizz.infra.ActorSearch.ActorSearchResult;

import java.util.List;

public class FakeTheMovieDBClient implements TheMovieDBClient {
    @Override
    public MovieCredits getMovieCredits(Long personId, String apiKey, String language) {
        List<Movie> movies;
        // allows to have a different behavior when calling getMovieCredits after calling getActor (ie in getMovieTheActorPlayedIn)
        if (personId == 1L) {
            movies = List.of(new Movie("title 3", "original title 3"),
                    new Movie("title 4", "original title 4"));
        } else {
            movies = List.of(new Movie("title 1", "original title 1"),
                    new Movie("title 2", "original title 2"));
        }
        return new MovieCredits(movies);
    }

    @Override
    public ActorSearch getActor(String actorName, String apiKey, String language) {
        return new ActorSearch(List.of(new ActorSearchResult(1L)));
    }
}
