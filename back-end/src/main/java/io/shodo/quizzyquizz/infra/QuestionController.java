package io.shodo.quizzyquizz.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private final TheMovieDBService theMovieDBService;

    @Autowired
    public QuestionController(TheMovieDBService theMovieDBService) {
        this.theMovieDBService = theMovieDBService;
    }

}
