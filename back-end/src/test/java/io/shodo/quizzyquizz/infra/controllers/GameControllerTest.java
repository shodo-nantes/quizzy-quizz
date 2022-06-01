package io.shodo.quizzyquizz.infra.controllers;

import com.jayway.jsonpath.JsonPath;
import io.shodo.quizzyquizz.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private QuestionsProvider questionProvider;
    @Autowired
    private AnswersProvider answersProvider;

    @Test
    void create_a_random_game_should_returns_a_200() throws Exception {
        this.mockMvc.perform(post("/games/random"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("question").isNotEmpty());
    }

    @Test
    void get_a_created_game_returns_the_corresponding_game() throws Exception {
        MvcResult randomGame = this.mockMvc.perform(post("/games/random")).andReturn();

        String id = JsonPath.read(randomGame.getResponse().getContentAsString(), "$.id");
        this.mockMvc.perform(get("/games/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").isNotEmpty())
                .andExpect(jsonPath("id").value(id));
    }

    @Test
    void should_answering_a_good_answer_return_true() throws Exception {
        Game game = new CreateGame(questionProvider, answersProvider).fromActorAndQuestionType("BRAD PITT", Question.QuestionType.MOVIES_THE_ACTOR_PLAYED_IN);
        String answer = "Troy";
        String gameId = game.getId().toString();
        this.mockMvc.perform(post("/games/" + gameId + "/answer")
                        .contentType(APPLICATION_JSON)
                        .content(
                                """
                                        {"answer": "%s"}
                                        """.formatted(answer)
                        )
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("result").value(true));
    }

    @Test
    void should_answering_a_wrong_answer_return_false() throws Exception {
        Game game = new CreateGame(questionProvider, answersProvider).random();
        String answer = "Intouchables";
        String gameId = game.getId().toString();
        this.mockMvc.perform(post("/games/" + gameId + "/answer")
                        .contentType(APPLICATION_JSON)
                        .content(
                                """
                                        {"answer": "%s"}
                                        """.formatted(answer)
                        )
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("result").value(false));
    }


}
