package io.shodo.quizzyquizz;

public class CreateGame {
    QuestionsProvider questionsProvider;
    public CreateGame(QuestionsProvider questionsProvider) {
        this.questionsProvider = questionsProvider;
    }

    Game random() {
        return new Game(questionsProvider.getRandomQuestion());
    }
}