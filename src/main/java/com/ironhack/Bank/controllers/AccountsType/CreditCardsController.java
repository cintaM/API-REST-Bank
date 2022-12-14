package com.ironhack.Bank.controllers.AccountsType;

import com.ironhack.Bank.controllers.DTOs.CreditDTO;
import com.ironhack.Bank.controllers.interfaces.AccountsType.CreditCardsControllerInterface;
import com.ironhack.Bank.entity.AccountsType.CreditCards;
import com.ironhack.Bank.entity.Embeddable.Money;
import com.ironhack.Bank.entity.UsersType.ThirdParty;
import com.ironhack.Bank.services.AccountsType.CreditCardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class CreditCardsController implements CreditCardsControllerInterface {

    @Autowired
    CreditCardsService creditCardService;




    @PostMapping("/creditcard/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreditCards addCreditCards(@RequestBody CreditDTO creditCards)  {
        return creditCardService.addCreditCards(creditCards);

    }


    @PatchMapping("/creditcards/patch/{id}")
    public CreditCards updateCreditCardsBalance(@PathVariable Long id, @RequestBody Long balance) {
        return creditCardService.updateCreditCardsBalance(id, new Money(BigDecimal.valueOf(balance)));
    }



    @DeleteMapping("/creditcard/delete/")
    public void deleteCreditCards(CreditCards creditCards) {
        creditCardService.deleteCreditCards(creditCards);
    }


    @PutMapping("/creditcards/put/{id}")
    public CreditCards updateCreditCards(@PathVariable Long id, @RequestBody CreditCards creditCards) {
        return creditCardService.updateCreditCards(id, creditCards);
    }

    @GetMapping("/creditcards/getall")
    public List<CreditCards> getAllCreditCards(){
        return creditCardService.getAllCreditCards();
    }

    @GetMapping("/creditcards/get/{id}")
    public CreditCards getOneCreditCards(@PathVariable Long id){
        return  creditCardService.getOneCreditCards(id);
    }

}
