package io.shodo.quizzyquizz.domain;

record Game(Question question) {

    boolean answer(String answer){
        return this.question().answers().contains(answer);
    }

}
