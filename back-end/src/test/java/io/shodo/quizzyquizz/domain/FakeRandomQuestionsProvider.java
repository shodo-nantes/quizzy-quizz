package io.shodo.quizzyquizz.domain;

import io.shodo.quizzyquizz.infra.Questions;

class FakeRandomQuestionsProvider implements QuestionsProvider {

    @Override
    public Question getRandomQuestion() {
        return Questions.getInstance().getQuestions().get(0);
    }
}
