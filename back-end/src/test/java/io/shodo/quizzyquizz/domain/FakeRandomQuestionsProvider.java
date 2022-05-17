package io.shodo.quizzyquizz.domain;

class FakeRandomQuestionsProvider implements QuestionsProvider {

    @Override
    public Question getRandomQuestion() {
        return Question.LIST_CHARLIZE_THERON_MOVIES;
    }
}
