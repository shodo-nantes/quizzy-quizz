package io.shodo.quizzyquizz.infra.rest;

public record Movie(String title, String original_title) {

    //TODO remove that
    @Override
    public String toString() {
        return "title:'" + title + '\'' +
                ", original title:'" + original_title + '\'';
    }
}
