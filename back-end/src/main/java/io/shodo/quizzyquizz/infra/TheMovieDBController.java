package io.shodo.quizzyquizz.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")

public class TheMovieDBController {

    @Autowired
    public TheMovieDBController(TheMovieDBService theMovieDBService) {
    }

}
