package io.shodo.quizzyquizz.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgifyService {

    private final AgifyClient agifyClient;

    @Autowired
    public AgifyService(AgifyClient agifyClient) {
        this.agifyClient = agifyClient;
    }

    public String printAge(){
        return agifyClient.getAge("michael");
    }
}
