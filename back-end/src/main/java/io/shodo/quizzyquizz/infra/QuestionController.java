package io.shodo.quizzyquizz.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private final TheMovieDBService theMovieDBService;

    @Autowired
    public QuestionController(TheMovieDBService theMovieDBService) {
        this.theMovieDBService = theMovieDBService;
    }

    @GetMapping("/moviesTheActorPlayedIn")
    List<Movie> getMoviesTheActorPlayedIn(@RequestParam String actor) {
        Long actorId = theMovieDBService.getActorId(actor);
        return theMovieDBService.getMovieCredits(actorId);
    }
}
