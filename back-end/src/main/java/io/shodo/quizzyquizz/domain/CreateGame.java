package io.shodo.quizzyquizz.domain;

public class CreateGame {
    QuestionsProvider questionsProvider;
    public CreateGame(QuestionsProvider questionsProvider) {
        this.questionsProvider = questionsProvider;
    }

    public Game random() {
        Game newGame = new Game(questionsProvider.getRandomQuestion());
        Games.getInstance().addNewGame(newGame);
        return newGame;
    }
}