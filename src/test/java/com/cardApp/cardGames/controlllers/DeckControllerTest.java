package com.cardApp.cardGames.controlllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.cardApp.cardGames.controllers.DeckController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(DeckController.class)
public class DeckControllerTest implements ControllerTest {

    @Autowired
    private MockMvc mock;
    // Test /deck/newDeck
    @Test
    public void shouldCreateNewDeck() throws Exception{
        this.mock.perform(
            get("/deck/newDeck")
        ).andDo(print());
    }

    // Test /deck/newDeck?suffle=true
    @Test
    public void shouldCreateShuffledDeck() throws Exception{
        this.mock.perform(
            get("/deck/newDeck")
            .param("shuffle", "true")
        ).andDo(print());
    }
    //Test /deck/
    @Test
    public void shouldGetDeck() throws Exception{
        this.mock.perform(
            get("/deck/newDeck")
            .param("shuffle", "true")
        ).andDo(print());
    }
    // Test /deck/draw

    // Test /deck/draw?id= {id}

    // Test /deck/draw?id= {id} &fromBottom=true
}
