package io.shodo.quizzyquizz.domain;

import static java.util.Collections.singletonList;

public class FakeAnswersProvider implements AnswersProvider {
    @Override
    public Answers getAnswersFor(Question randomQuestion) {
        return new Answers(singletonList(new Movie("Scandale", "Bombshell")));
    }
}
