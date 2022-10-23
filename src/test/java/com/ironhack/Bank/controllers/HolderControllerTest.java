package com.ironhack.Bank.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ironhack.Bank.entity.AccountsType.CreditCards;
import com.ironhack.Bank.entity.Embeddable.Money;
import com.ironhack.Bank.entity.Embeddable.PrimaryAddress;
import com.ironhack.Bank.entity.UsersType.Holders;
import com.ironhack.Bank.repositories.AccountsType.CreditCardsRepository;
import com.ironhack.Bank.respositories.UsersType.HoldersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class HolderControllerTest {

    @Autowired
    CreditCardsRepository creditCardRepository;

    @Autowired
    HoldersRepository holdersRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;


    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());;

    Holders holder1;
    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();





    }

   /* @Test
    void get_All_OK() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/product")).andExpect(status().isOk()).andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Super Smash Bros"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("49.99"));

        System.out.println(mvcResult.getResponse().getContentAsString());

    }

    */

    @Test
    void post_CreditCards_isCreated() throws Exception {
        holder1 = holdersRepository.save(new Holders("Daniel", LocalDate.of(1985, 6, 26), new PrimaryAddress("ere", 2, "Barcelona"),
                "ijil@gjdj.com"));

        CreditCards creditCard1 = creditCardRepository.save(new CreditCards(new Money(BigDecimal.valueOf(1000)), holder1, holder1, BigDecimal.valueOf(2.25), new Money(BigDecimal.valueOf(654)), BigDecimal.valueOf(200)));
        String body = objectMapper.writeValueAsString(creditCard1);
        System.out.println(body);

        MvcResult mvcResult =mockMvc.perform(post("/creditcards").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andReturn();

        assertTrue(creditCardRepository.findById(2L).isPresent());

    }
}
