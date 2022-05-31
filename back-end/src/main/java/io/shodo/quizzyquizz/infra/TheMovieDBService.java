package io.shodo.quizzyquizz.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheMovieDBService {

    private final TheMovieDBClient theMovieDBClient;

    @Autowired
    public TheMovieDBService(TheMovieDBClient theMovieDBClient) {
        this.theMovieDBClient = theMovieDBClient;
    }

    List<Movie> getMovieCredits(Long personId) {
        return theMovieDBClient.getMovieCredits(personId, "4461da6b443fef45788c3c171a154582", "fr").cast();
    }

    Long getActorId(String actorName) {
        return theMovieDBClient.getActor(actorName, "4461da6b443fef45788c3c171a154582", "fr").results().get(0).id();
    }

    List<Movie> getMovieTheActorPlayedIn(String actor) {
        Long actorId = getActorId(actor);
        return getMovieCredits(actorId);
    }

}
