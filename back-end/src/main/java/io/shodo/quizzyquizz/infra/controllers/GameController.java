package io.shodo.quizzyquizz.infra.controllers;

import io.shodo.quizzyquizz.domain.AllGames;
import io.shodo.quizzyquizz.domain.AnswersProvider;
import io.shodo.quizzyquizz.domain.Game;
import io.shodo.quizzyquizz.domain.usecase.AnswerQuestion;
import io.shodo.quizzyquizz.domain.usecase.CreateGame;
import io.shodo.quizzyquizz.infra.providers.QuestionsProvider;
import io.shodo.quizzyquizz.infra.rest.ActorSearch;
import io.shodo.quizzyquizz.infra.rest.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/games")
public class GameController {

    private final QuestionsProvider randomQuestionsProvider;
    private final AnswersProvider answersProvider;
    private final AllGames allGames;

    @Autowired
    public GameController(QuestionsProvider randomQuestionsProvider, AnswersProvider answersProvider, AllGames allGames) {
        this.randomQuestionsProvider = randomQuestionsProvider;

        this.answersProvider = answersProvider;
        this.allGames = allGames;
    }

    @PostMapping("/random")
    public Game createRandomGame() {
        return new CreateGame(randomQuestionsProvider, answersProvider, allGames).random();
    }

    @GetMapping("/{id}")
    public Game getGame(@PathVariable String id) {
        return allGames.findBy(UUID.fromString(id)).orElseThrow(IllegalStateException::new);
    }

    @PostMapping("/{id}/answer")
    public ActorSearch.QuestionResult answer(@PathVariable String id, @RequestBody Answer answer) {
        boolean result = new AnswerQuestion(allGames).answer(id, answer);
        return new ActorSearch.QuestionResult(result);
    }
}
