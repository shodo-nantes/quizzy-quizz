package io.shodo.quizzyquizz.infra;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class QuestionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void calling_get_MOVIES_THE_ACTOR_PLAYED_IN_returns_a_list_of_movies_associated_with_the_actor() throws Exception {
        String actor = "Brad Pitt";
        this.mockMvc.perform(
                        get("/questions/moviesTheActorPlayedIn")
                                .param("actor", actor)
                )
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


}
