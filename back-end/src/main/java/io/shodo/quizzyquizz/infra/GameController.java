package io.shodo.quizzyquizz.infra;

import io.shodo.quizzyquizz.domain.CreateGame;
import io.shodo.quizzyquizz.domain.Game;
import io.shodo.quizzyquizz.domain.Games;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/games")
public class GameController {

    private final RandomQuestionsProvider randomQuestionsProvider;

    @Autowired
    public GameController(RandomQuestionsProvider randomQuestionsProvider) {
        this.randomQuestionsProvider = randomQuestionsProvider;

    }

    @GetMapping
    public Game createRandomGame() {return createGameService.createRandomGame();}
}
