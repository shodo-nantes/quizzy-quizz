package io.shodo.quizzyquizz.domain;

import java.util.UUID;

public class CreateGame {
    QuestionsProvider questionsProvider;
    AnswersProvider answersProvider;

    public CreateGame(QuestionsProvider questionsProvider, AnswersProvider answersProvider) {
        this.questionsProvider = questionsProvider;
        this.answersProvider = answersProvider;
    }

    public Game random() {
        Question randomQuestion = questionsProvider.getRandomQuestion();
        Answers answers = answersProvider.getAnswersFor(randomQuestion);
        Game newGame = new Game(randomQuestion, answers, UUID.randomUUID());
        Games.getInstance().addNewGame(newGame);
        return newGame;
    }

    //TODO create game où on passe un actor et un type de question
}