package io.shodo.quizzyquizz.infra.adapters;

import io.shodo.quizzyquizz.infra.rest.Movie;
import io.shodo.quizzyquizz.infra.rest.TheMovieDBClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheMovieDBAdapter {

    private final TheMovieDBClient theMovieDBClient;

    @Autowired
    public TheMovieDBAdapter(TheMovieDBClient theMovieDBClient) {
        this.theMovieDBClient = theMovieDBClient;
    }

    private List<Movie> getMovieCredits(Long personId) {
        return theMovieDBClient.getMovieCredits(personId, "4461da6b443fef45788c3c171a154582", "fr").cast();
    }

    private Long getActorId(String actorName) {
        return theMovieDBClient.getActor(actorName, "4461da6b443fef45788c3c171a154582", "fr").results().get(0).id();
    }

    public List<Movie> getMovieTheActorPlayedIn(String actor) {
        Long actorId = getActorId(actor);
        return getMovieCredits(actorId);
    }

}
