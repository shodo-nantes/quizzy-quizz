package io.shodo.quizzyquizz.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")

public class TheMovieDBController {
    private final TheMovieDBService theMovieDBService;

    @Autowired
    public TheMovieDBController(TheMovieDBService theMovieDBService) {
        this.theMovieDBService = theMovieDBService;
    }

    @GetMapping
    public String getMovieCredits() { return theMovieDBService.printMovieCredits(); }

}
