package io.shodo.quizzyquizz.infra;

import io.shodo.quizzyquizz.domain.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games/create/random")
public class CreateGameController {

    private final CreateGameService createGameService;

    @Autowired
    public CreateGameController(CreateGameService createGameService) {
        this.createGameService = createGameService;
    }

    @GetMapping
    public Game createRandomGame() {return createGameService.createRandomGame();}
}
