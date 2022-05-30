package io.shodo.quizzyquizz.infra;

import io.shodo.quizzyquizz.infra.ActorSearch.ActorSearchResult;

import java.util.List;

public class FakeTheMovieDBClient implements TheMovieDBClient {
    @Override
    public MovieCredits getMovieCredits(Long personId, String apiKey, String language) {
        List<Movie> movies = List.of(new Movie("title 1", "original title 1"),
                new Movie("title 2", "original title 2"));
        return new MovieCredits(movies);
    }

    @Override
    public ActorSearch getActor(String actorName, String apiKey, String language) {
        return new ActorSearch(List.of(new ActorSearchResult(1L)));
    }
}
