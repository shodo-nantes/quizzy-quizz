package io.shodo.quizzyquizz.domain;

class FakeRandomQuestionsProvider implements QuestionsProvider {

    //TODO est-ce qu'on garde le FakeRandomQuestionProvider pour tester CreateGameTest ou est-ce qu'on utilise l'implémentation maintenant qu'elle est dev ?
    @Override
    public Question getRandomQuestion() {
        return Question.LIST_CHARLIZE_THERON_MOVIES;
    }
}
