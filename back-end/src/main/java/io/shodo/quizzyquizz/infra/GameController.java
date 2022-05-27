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

    @PostMapping("/random")
    public Game createRandomGame() {
        return new CreateGame(randomQuestionsProvider).random();
    }

    @GetMapping("/{id}")
    public Game getGame(@PathVariable String id) {
        return Games.getInstance().getGame(UUID.fromString(id));
    }

    @PostMapping("/{id}/answer")
    public QuestionResult answer(@PathVariable String id, @RequestBody Answer answer) {
        Game game = Games.getInstance().getGame(UUID.fromString(id));
        return new QuestionResult(game.answer(answer.answer()));

    }
}
