package io.shodo.quizzyquizz.domain;

public interface QuestionsProvider {
    Question getRandomQuestion();

    Question getQuestionFromActorAndType(String actor, Question.QuestionType questionType);
}
