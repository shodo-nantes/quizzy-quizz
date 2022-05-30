package io.shodo.quizzyquizz.domain;

import io.shodo.quizzyquizz.domain.Question.QuestionType;

class FakeRandomQuestionsProvider implements QuestionsProvider {

    @Override
    public Question getRandomQuestion() {
        return Questions.getInstance().getQuestions().get(0);
    }

    @Override
    public Question getQuestionFromActorAndType(String actor, QuestionType questionType) {
        return new Question(actor, questionType);
    }
}
