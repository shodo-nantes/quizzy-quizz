package io.shodo.quizzyquizz.domain;

class AnswerGame {
    Game game;
    String answer;

    public AnswerGame(Game game, String answer) {
        this.game = game;
        this.answer = answer;
    }

    boolean validate() {
        return this.game.question().answers().contains(this.answer);
    }
}
