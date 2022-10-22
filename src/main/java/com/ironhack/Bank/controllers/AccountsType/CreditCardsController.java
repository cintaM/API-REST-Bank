package com.ironhack.Bank.controllers.AccountsType;

import com.ironhack.Bank.controllers.DTOs.CreditDTO;
import com.ironhack.Bank.controllers.interfaces.AccountsType.CreditCardsControllerInterface;
import com.ironhack.Bank.entity.AccountsType.CreditCards;
import com.ironhack.Bank.services.AccountsType.CreditCardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreditCardsController implements CreditCardsControllerInterface {

    @Autowired
    CreditCardsService creditCardService;


    @PostMapping("/creditcards")
    @ResponseStatus(HttpStatus.CREATED)
    public CreditCards addCreditCards(@RequestBody CreditCards creditCards)  {
        return creditCardService.addCreditCards(creditCards);

    }


    @PostMapping("/creditcards2")
    @ResponseStatus(HttpStatus.CREATED)
    public CreditCards addCreditCards2(@RequestBody CreditDTO creditCards)  {
        return creditCardService.addCreditCards2(creditCards);

    }


    @PatchMapping("/creditcards/{id}")
    public CreditCards updateCreditCardsBalance(@PathVariable Long id, @RequestBody Money balance) {
        return creditCardService.updateCreditCardsBalance(id, new Money());
    }

   @DeleteMapping("/deleteCreditCards")
    public CreditCards deleteCreditCards(@RequestBody CreditCards creditCards) {
        return creditCardService.deleteCreditCards(creditCards);
    }




}
