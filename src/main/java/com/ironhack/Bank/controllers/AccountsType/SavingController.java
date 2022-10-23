package com.ironhack.Bank.controllers.AccountsType;

import com.ironhack.Bank.controllers.DTOs.CreditDTO;
import com.ironhack.Bank.controllers.DTOs.SavingDTO;
import com.ironhack.Bank.controllers.interfaces.AccountsType.SavingControllerInterface;
import com.ironhack.Bank.entity.AccountsType.CreditCards;
import com.ironhack.Bank.entity.AccountsType.Saving;
import com.ironhack.Bank.entity.Embeddable.Money;
import com.ironhack.Bank.entity.UsersType.ThirdParty;
import com.ironhack.Bank.services.AccountsType.CreditCardsService;
import com.ironhack.Bank.services.AccountsType.SavingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class SavingController implements SavingControllerInterface {

    @Autowired
    SavingService savingService;


    @PostMapping("/saving/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Saving addSaving(@RequestBody SavingDTO savingDTO)  {
        return savingService.addSaving(savingDTO);

    }


    @PatchMapping("/saving/{id}")
    public Saving updateSavingBalance(@PathVariable Long id, @RequestBody Long balance) {
        return savingService.updateSavingBalance(id, new Money(BigDecimal.valueOf(balance)));
    }

    @DeleteMapping("/saving/delete/")
    public Saving deleteCreditCards() {
        return savingService.deleteSaving();
    }

    @GetMapping("/thirdparty/getall")
    public List<Saving> getAllSaving(){
        return savingService.getAllSaving();
    }

    @GetMapping("/thirdparty/get/{id}")
    public Saving getOneSaving(@PathVariable Long id){
        return  savingService.getOneSaving(id);
    }
}
