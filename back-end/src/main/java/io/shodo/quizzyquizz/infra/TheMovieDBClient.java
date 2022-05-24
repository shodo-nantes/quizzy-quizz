package io.shodo.quizzyquizz.infra;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "themoviedb", url = "https://api.themoviedb.org/3/")
public interface TheMovieDBClient {
    //TODO comment tester theMovieDBClient et les appels APIs
    @GetMapping(value = "/person/{personId}/movie_credits")
    MovieCredits getMovieCredits(@PathVariable("personId") Long personId, @RequestParam("api_key") String apiKey, @RequestParam("language") String language);

    @GetMapping("/search/person")
    ActorSearch getActor(@RequestParam("query") String actorName, @RequestParam("api_key") String apiKey, @RequestParam("language") String language);
}