package io.shodo.quizzyquizz.infra.rest;

import io.shodo.quizzyquizz.domain.ValidAnswer;

public record Movie(String title, String original_title) {

    //TODO remove that
    @Override
    public String toString() {
        return "title:'" + title + '\'' +
                ", original title:'" + original_title + '\'';
    }

    public ValidAnswer toAnswer(){
        return new io.shodo.quizzyquizz.domain.Movie(title, original_title);
    }
}
