package io.shodo.quizzyquizz.infra;

import io.shodo.quizzyquizz.domain.CreateGame;
import io.shodo.quizzyquizz.domain.Game;
import io.shodo.quizzyquizz.domain.QuestionsProvider;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CreateGameService {

    CreateGame createGame;

    public CreateGameService() {
        createGame = new CreateGame(new RandomQuestionsProvider(new Random(123L)));
    }

    public Game createRandomGame() {
        return createGame.random();
    }
}
