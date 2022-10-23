package com.ironhack.Bank.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ironhack.Bank.entity.AccountsType.Checking;
import com.ironhack.Bank.entity.AccountsType.CreditCards;
import com.ironhack.Bank.entity.Embeddable.Money;
import com.ironhack.Bank.entity.Embeddable.PrimaryAddress;
import com.ironhack.Bank.entity.UsersType.Holders;
import com.ironhack.Bank.enums.Status;
import com.ironhack.Bank.enums.Types;
import com.ironhack.Bank.repositories.AccountsType.CheckingRepository;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class CheckingControllerTest {

    @Autowired
    CheckingRepository checkingRepository;

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
    void post_Checking_isCreated() throws Exception {
        holder1 = holdersRepository.save(new Holders("Daniel", LocalDate.of(1985, 6, 26), new PrimaryAddress("ere", 2, "Barcelona"),
                "ijil@gjdj.com"));

        Checking checking = checkingRepository.save(new Checking(new Money(BigDecimal.valueOf(2533)), holder1, holder1, BigDecimal.valueOf(0.2), "sdfs", new Money(BigDecimal.valueOf(250)),BigDecimal.valueOf(1.5), Status.ACTIVE, Types.CHECKING ));
        String body = objectMapper.writeValueAsString(checking);
        System.out.println(body);

        MvcResult mvcResult =mockMvc.perform(post("/checking/add").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andReturn();

        assertTrue(checkingRepository.findById(2L).isPresent());

    }

    @Test
    void get_All_OK() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/creditcard/getall")).andExpect(status().isOk()).andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("0.2"));

        System.out.println(mvcResult.getResponse().getContentAsString());

    }

    @Test
    void get_ById_OK() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/creditcard/getone/1")).andExpect(status().isOk()).andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("0.2"));

        System.out.println(mvcResult.getResponse().getContentAsString());

    }

    @Test
    void get_SetBalance_OK() throws Exception {
        holder1 = holdersRepository.save(new Holders("Daniel", LocalDate.of(1985, 6, 26), new PrimaryAddress("ere", 2, "Barcelona"),
                "ijil@gjdj.com"));

        Checking checking = checkingRepository.save(new Checking(new Money(BigDecimal.valueOf(2533)), holder1, holder1, BigDecimal.valueOf(0.2), "sdfs", new Money(BigDecimal.valueOf(250)),BigDecimal.valueOf(1.5), Status.ACTIVE, Types.CHECKING ));
        checking.setBalance(new Money(BigDecimal.valueOf(250)));
        MvcResult mvcResult = mockMvc.perform(patch("/checking/patch/1")).andExpect(status().isOk()).andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
        assertTrue(mvcResult.getResponse().getContentAsString().contains("250"));
    }

    @Test
    void Delete_OK() throws Exception {
        MvcResult mvcResult = mockMvc.perform(delete("/checking/delete/1")).andExpect(status().isOk()).andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());

    }

    @Test
    void Put_OK() throws Exception {
        MvcResult mvcResult = mockMvc.perform(put("/creditcard/put/1")).andExpect(status().isOk()).andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("0.2"));

        System.out.println(mvcResult.getResponse().getContentAsString());

    }


}
