package io.shodo.quizzyquizz.infra;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "agify", url = "https://api.agify.io")
public interface AgifyClient {
    @GetMapping()
    String getAge(@RequestParam("name") String name);
}