package io.shodo.quizzyquizz;

class FakeRandomQuestionsProvider implements QuestionsProvider {

    @Override
    public Question getRandomQuestion() {
        return Question.LIST_ACTOR_MOVIE;
    }
}
