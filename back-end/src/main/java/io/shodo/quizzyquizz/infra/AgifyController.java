package io.shodo.quizzyquizz.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")

public class AgifyController {
    private final AgifyService agifyService;

    @Autowired
    public AgifyController(AgifyService agifyService) {
        this.agifyService = agifyService;
    }

    @GetMapping
    public String getName() { return agifyService.printAge(); }

}
