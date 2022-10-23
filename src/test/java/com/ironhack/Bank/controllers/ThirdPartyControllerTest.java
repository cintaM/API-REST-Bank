package com.ironhack.Bank.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ironhack.Bank.entity.AccountsType.CreditCards;
import com.ironhack.Bank.entity.Embeddable.Money;
import com.ironhack.Bank.entity.Embeddable.PrimaryAddress;
import com.ironhack.Bank.entity.UsersType.Holders;
import com.ironhack.Bank.entity.UsersType.ThirdParty;
import com.ironhack.Bank.repositories.AccountsType.CreditCardsRepository;
import com.ironhack.Bank.respositories.UsersType.HoldersRepository;
import com.ironhack.Bank.respositories.UsersType.ThirdPartyRepository;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class ThirdPartyControllerTest {
    @Autowired
    ThirdPartyRepository thirdParty;

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;


    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());;

    Holders holder1;
    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();


    }


    @Test
    void post_ThirdParty_isCreated() throws Exception {
        ThirdParty thirdParty1 = thirdParty.save(new ThirdParty("jasd", "Tienda Manolita"));

        String body = objectMapper.writeValueAsString(thirdParty1);
        System.out.println(body);

        MvcResult mvcResult =mockMvc.perform(post("/thirdparty/add").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andReturn();

        assertTrue(thirdParty.findById(2L).isPresent());

    }
    @Test
    void get_All_OK() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/thirdparty/getall")).andExpect(status().isOk()).andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Super super"));


        System.out.println(mvcResult.getResponse().getContentAsString());

    }

    @Test
    void get_ById_OK() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/thirdparty/getone/1")).andExpect(status().isOk()).andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Super super"));

        System.out.println(mvcResult.getResponse().getContentAsString());

    }


    @Test
    void Delete_OK() throws Exception {
        MvcResult mvcResult = mockMvc.perform(delete("/thirdparty/delete/1")).andExpect(status().isOk()).andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());

    }
}
