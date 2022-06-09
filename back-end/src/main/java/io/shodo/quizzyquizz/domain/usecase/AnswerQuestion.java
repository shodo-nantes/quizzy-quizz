package io.shodo.quizzyquizz.domain.usecase;

import io.shodo.quizzyquizz.domain.AllGames;
import io.shodo.quizzyquizz.domain.Game;
import io.shodo.quizzyquizz.domain.PlayerAnswer;
import io.shodo.quizzyquizz.infra.rest.Answer;

import java.util.UUID;

public class AnswerQuestion {
    private final AllGames allGames;

    public AnswerQuestion(AllGames allGames) {
        this.allGames = allGames;
    }

    public boolean answer(String id, Answer answer) {
        Game game = allGames.findBy(UUID.fromString(id)).orElseThrow(IllegalStateException::new);
        return game.answer(new PlayerAnswer(answer.answer()));
    }
}
