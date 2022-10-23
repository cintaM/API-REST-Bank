package com.ironhack.Bank.controllers.AccountsType;

import com.ironhack.Bank.controllers.DTOs.CreditDTO;
import com.ironhack.Bank.controllers.DTOs.SavingDTO;
import com.ironhack.Bank.controllers.interfaces.AccountsType.SavingControllerInterface;
import com.ironhack.Bank.entity.AccountsType.CreditCards;
import com.ironhack.Bank.entity.Embeddable.Money;
import com.ironhack.Bank.entity.UsersType.ThirdParty;
import com.ironhack.Bank.services.AccountsType.CreditCardsService;
import com.ironhack.Bank.services.AccountsType.SavingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SavingController implements SavingControllerInterface {

    @Autowired
    SavingService savingService;


    @PostMapping("/saving/add")
    @ResponseStatus(HttpStatus.CREATED)
    public SavingDTO addSaving(@RequestBody SavingDTO savingDTO)  {
        return savingService.addSaving(savingDTO);

    }


    @PatchMapping("/saving/{id}")
    public SavingDTO updateCreditCardsBalance(@PathVariable Long id, @RequestBody Money balance) {
        return savingService.updateSavingBalance(id, balance);
    }

    @DeleteMapping("/deleteCreditCards")
    public SavingDTO deleteCreditCards(@RequestBody SavingDTO savingDTO) {
        return savingService.deleteSaving(savingDTO);
    }

    @GetMapping("/thirdparty/getall")
    public List<SavingDTO> getAllSaving(){
        return savingService.getAllThirdParty();
    }

    @GetMapping("/thirdparty/get/{id}")
    public SavingDTO getOneSaving(@PathVariable Long id, @RequestBody SavingDTO savingDTO){
        return  savingService.getOneThirdParty(id, savingDTO);
    }
}
