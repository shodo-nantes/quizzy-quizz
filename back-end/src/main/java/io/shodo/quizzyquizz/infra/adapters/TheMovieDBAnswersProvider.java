package io.shodo.quizzyquizz.infra.adapters;

import io.shodo.quizzyquizz.domain.Answers;
import io.shodo.quizzyquizz.domain.AnswersProvider;
import io.shodo.quizzyquizz.domain.Question;
import io.shodo.quizzyquizz.domain.ValidAnswer;
import io.shodo.quizzyquizz.infra.rest.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Collections.emptyList;

@Component
public class TheMovieDBAnswersProvider implements AnswersProvider {

    private final TheMovieDBAdapter theMovieDBAdapter;

    @Autowired
    public TheMovieDBAnswersProvider(TheMovieDBAdapter theMovieDBAdapter) {
        this.theMovieDBAdapter = theMovieDBAdapter;
    }

    @Override
    public Answers getAnswersFor(Question randomQuestion) {
        switch (randomQuestion.getType()) {
            case MOVIES_THE_ACTOR_PLAYED_IN -> {
                List<Movie> movies = theMovieDBAdapter.getMovieTheActorPlayedIn(randomQuestion.getActor());
                List<ValidAnswer> moviesString = movies.stream().map(Movie::toAnswer).toList();
                return new Answers(moviesString);
            }
            case ACTORS_THE_ACTOR_PLAYED_WITH -> {
                return new Answers(emptyList()); //TODO implements the method
            }
            default ->
                    throw new IllegalArgumentException("cannot fetch answers for type:" + randomQuestion.getType() + ". The behavior is not defined in the application.");
        }
    }
}
