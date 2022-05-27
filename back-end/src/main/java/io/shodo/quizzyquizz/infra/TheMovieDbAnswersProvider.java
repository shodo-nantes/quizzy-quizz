package io.shodo.quizzyquizz.infra;

import io.shodo.quizzyquizz.domain.Answers;
import io.shodo.quizzyquizz.domain.AnswersProvider;
import io.shodo.quizzyquizz.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TheMovieDbAnswersProvider implements AnswersProvider {

    private final TheMovieDBService theMovieDBService;

    @Autowired
    public TheMovieDbAnswersProvider(TheMovieDBService theMovieDBService) {
        this.theMovieDBService = theMovieDBService;
    }

    @Override
    public Answers getAnswersFor(Question randomQuestion) {
        return null;
    }
}
