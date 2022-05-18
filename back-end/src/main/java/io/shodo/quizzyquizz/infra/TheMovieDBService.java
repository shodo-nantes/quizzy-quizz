package io.shodo.quizzyquizz.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheMovieDBService {

    private final TheMovieDBClient theMovieDBClient;

    @Autowired
    public TheMovieDBService(TheMovieDBClient theMovieDBClient) {
        this.theMovieDBClient = theMovieDBClient;
    }

    public String printMovieCredits(){
        return theMovieDBClient.getMovieCredits(287L, "4461da6b443fef45788c3c171a154582", "fr").toString();
    }
}
