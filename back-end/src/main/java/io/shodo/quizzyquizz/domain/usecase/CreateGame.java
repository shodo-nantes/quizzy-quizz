package io.shodo.quizzyquizz.domain.usecase;

import io.shodo.quizzyquizz.domain.*;
import io.shodo.quizzyquizz.domain.Question.QuestionType;

import java.util.UUID;

public class CreateGame {
    private final QuestionsProvider questionsProvider;
    private final AnswersProvider answersProvider;
    private final AllGames allGames;

    public CreateGame(QuestionsProvider questionsProvider, AnswersProvider answersProvider, AllGames allGames) {
        this.questionsProvider = questionsProvider;
        this.answersProvider = answersProvider;
        this.allGames = allGames;
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
        return allGames.save(new Game(question, answers, UUID.randomUUID()));
    }

}
