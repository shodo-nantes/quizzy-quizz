package io.shodo.quizzyquizz.domain;

class FakeRandomQuestionsProvider implements QuestionsProvider {

    @Override
    public Question getRandomQuestion() {
        return Questions.getInstance().getQuestions().get(0);
    }
}
