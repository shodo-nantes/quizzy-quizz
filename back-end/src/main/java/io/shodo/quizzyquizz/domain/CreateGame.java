package io.shodo.quizzyquizz.domain;

import io.shodo.quizzyquizz.domain.Question.QuestionType;

import java.util.UUID;

public class CreateGame {
    private final QuestionsProvider questionsProvider;
    private final AnswersProvider answersProvider;
    private final Games games;

    public CreateGame(QuestionsProvider questionsProvider, AnswersProvider answersProvider) {
        this.questionsProvider = questionsProvider;
        this.answersProvider = answersProvider;
        this.games = Games.getInstance();
    }

    public Game random() {
        Question randomQuestion = questionsProvider.getRandomQuestion();
        return fromQuestion(randomQuestion);
    }

    public Game fromActorAndQuestionType(String actor, QuestionType questionType) {
        Question question = questionsProvider.getQuestionFromActorAndType(actor, questionType);
        return fromQuestion(question);
    }

    private Game fromQuestion(Question question) {
        Answers answers = answersProvider.getAnswersFor(question);
        Game newGame = new Game(question, answers, UUID.randomUUID());
        games.save(newGame);
        return newGame;
    }

}
