package com.cardApp.cardGames.controlllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.UUID;

import com.cardApp.cardGames.controllers.DeckController;
import com.cardApp.cardGames.entities.Deck;
import com.cardApp.cardGames.repository.Decks;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;

@WebMvcTest(DeckController.class)
public class DeckControllerTest {

    @Autowired
    private MockMvc mock;

    @MockBean
    private Decks decks;

    // Test /deck/newDeck
    @Test
    public void shouldCreateNewDeck() throws Exception{
        UUID id = UUID.randomUUID();
        when(decks.add(any())).thenReturn(id);
        Deck d = new Deck();
        this.mock.perform(
            post("/deck/newDeck")
        ).andDo(print())
        .andExpect(jsonPath("$.id", is(id.toString())))
        .andExpect(jsonPath("$.deck.cards[0].number", is(d.getCards().get(0).getNumber())));
    }

    // Test /deck/newDeck?suffle=true
    @Test
    public void shouldCreateShuffledDeck() throws Exception{
        UUID id = UUID.randomUUID();
        when(decks.add(any())).thenReturn(id);
        Deck d = new Deck();
        this.mock.perform(
            post("/deck/newDeck")
            .param("shuffle", "true")
        ).andDo(print())
        .andExpect(jsonPath("$.id", is(id.toString())))
        .andExpect(jsonPath("$.deck.cards[0].number", is(not(d.getCards().get(0).getNumber()))));
    }
    //Test /deck/
    @Test
    public void shouldGetDeck() throws Exception{
        UUID id = UUID.randomUUID();
        when(decks.add(any())).thenReturn(id);
        Deck d = new Deck();
        when(decks.findDeckByID(any())).thenReturn(d);
        this.mock.perform(
            get("/deck/")
            .param("id",id.toString())
        ).andDo(print())
        .andExpect(jsonPath("$.id", is(id.toString())));
    }

    @Test
    public void shouldThrowNotFound() throws Exception{
        UUID id = UUID.randomUUID();
        this.mock.perform(
            get("/deck/")
            .param("id", id.toString())
        ).andDo(print())
        .andExpect(jsonPath("$.msg", containsString(id.toString())));
    }

    // Test /deck/draw
    @Test
    public void shouldDrawCard() throws Exception{
        UUID id = UUID.randomUUID();
        when(decks.add(any())).thenReturn(id);
        Deck d = new Deck();
        when(decks.findDeckByID(any())).thenReturn(d);
        this.mock.perform(
            get("/deck/draw")
            .param("id",id.toString())
        ).andDo(print())
        .andExpect(jsonPath("$.id", is(id.toString())))
        .andExpect(jsonPath("$.card.number", is(d.getDiscard().get(0).getNumber())));
    }

    // Test /deck/draw?id= {id} &fromBottom=true
    @Test
    public void shouldDrawCardFromBottom() throws Exception{
        UUID id = UUID.randomUUID();
        when(decks.add(any())).thenReturn(id);
        Deck d = new Deck();
        when(decks.findDeckByID(any())).thenReturn(d);
        this.mock.perform(
            get("/deck/draw")
            .param("id",id.toString())
            .param("fromBottom", "true")
        ).andDo(print())
        .andExpect(jsonPath("$.id", is(id.toString())))
        .andExpect(jsonPath("$.card.number", is(d.getDiscard().get(0).getNumber())));
    }
}
