package io.shodo.quizzyquizz.infra;

import io.shodo.quizzyquizz.domain.CreateGame;
import io.shodo.quizzyquizz.domain.Game;
import io.shodo.quizzyquizz.domain.QuestionsProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
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

    @Test
    void create_a_random_game_should_returns_a_200() throws Exception {
        this.mockMvc.perform(post("/games/random")).andExpect(status().isOk())
                .andExpect(jsonPath("question").isNotEmpty());
    }

    @Test
    void toto() throws Exception {
        Game randomGame = new CreateGame(questionProvider).random(); //TODO get id
        this.mockMvc.perform(post("/games/1234/answer").contentType(APPLICATION_JSON)
                        .content("""
                                {"answer": "Les schtroumpfs"}
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("question").isNotEmpty());
    }


}
