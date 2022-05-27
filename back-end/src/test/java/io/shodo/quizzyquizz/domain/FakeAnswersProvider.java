package io.shodo.quizzyquizz.domain;

import java.util.Collections;

public class FakeAnswersProvider implements AnswersProvider {
    @Override
    public Answers getAnswersFor(Question randomQuestion) {
        return new Answers(Collections.singletonList(new Answer("Bombshell")));
    }
}
