package com.ironhack.Bank.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ironhack.Bank.entity.AccountsType.CreditCards;
import com.ironhack.Bank.entity.AccountsType.Saving;
import com.ironhack.Bank.entity.Embeddable.Money;
import com.ironhack.Bank.entity.Embeddable.PrimaryAddress;
import com.ironhack.Bank.entity.UsersType.Holders;
import com.ironhack.Bank.enums.Status;
import com.ironhack.Bank.repositories.AccountsType.CreditCardsRepository;
import com.ironhack.Bank.repositories.AccountsType.SavingRepository;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class SavingControllerTest {
    @Autowired
    SavingRepository savingRepository;

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




    @Test
    void post_Saving_isCreated() throws Exception {
        holder1 = holdersRepository.save(new Holders("Daniel", LocalDate.of(1985, 6, 26), new PrimaryAddress("ere", 2, "Barcelona"),
                "ijil@gjdj.com"));
        Saving saving = new Saving(new Money(BigDecimal.valueOf(350)), holder1, holder1, BigDecimal.valueOf(0.2), "asaas", new Money(BigDecimal.valueOf(620)), Status.ACTIVE, BigDecimal.valueOf(1.3));
        String body = objectMapper.writeValueAsString(saving);
        System.out.println(body);

        MvcResult mvcResult =mockMvc.perform(post("/saving/add").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andReturn();

        assertTrue(savingRepository.findById(2L).isPresent());

    }

    @Test
    void get_All_OK() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/saving/getall")).andExpect(status().isOk()).andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("0.2"));

        System.out.println(mvcResult.getResponse().getContentAsString());

    }

    @Test
    void get_ById_OK() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/saving/getone/1")).andExpect(status().isOk()).andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("0.2"));

        System.out.println(mvcResult.getResponse().getContentAsString());

    }

    @Test
    void get_SetBalance_OK() throws Exception {
        holder1 = holdersRepository.save(new Holders("Daniel", LocalDate.of(1985, 6, 26), new PrimaryAddress("ere", 2, "Barcelona"),
                "ijil@gjdj.com"));
        Saving saving = new Saving(new Money(BigDecimal.valueOf(350)), holder1, holder1, BigDecimal.valueOf(0.2), "asaas", new Money(BigDecimal.valueOf(620)), Status.ACTIVE, BigDecimal.valueOf(1.3));
        String body = objectMapper.writeValueAsString(saving);
        MvcResult mvcResult = mockMvc.perform(patch("/saving/patch/1")).andExpect(status().isOk()).andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
        assertTrue(mvcResult.getResponse().getContentAsString().contains("0.2"));
    }

    @Test
    void Delete_OK() throws Exception {
        MvcResult mvcResult = mockMvc.perform(delete("/saving/delete/1")).andExpect(status().isOk()).andReturn();


        System.out.println(mvcResult.getResponse().getContentAsString());

    }

    @Test
    void Put_OK() throws Exception {
        MvcResult mvcResult = mockMvc.perform(put("/creditcard/put/1")).andExpect(status().isOk()).andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("0.2"));

        System.out.println(mvcResult.getResponse().getContentAsString());

    }
}
