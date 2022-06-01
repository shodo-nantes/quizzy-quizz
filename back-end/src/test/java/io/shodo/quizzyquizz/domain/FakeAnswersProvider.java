package io.shodo.quizzyquizz.domain;

import io.shodo.quizzyquizz.infra.rest.Answer;
import io.shodo.quizzyquizz.infra.rest.Answers;

import java.util.Collections;

public class FakeAnswersProvider implements AnswersProvider {
    @Override
    public Answers getAnswersFor(Question randomQuestion) {
        return new Answers(Collections.singletonList(new Answer("Bombshell")));
    }
}
