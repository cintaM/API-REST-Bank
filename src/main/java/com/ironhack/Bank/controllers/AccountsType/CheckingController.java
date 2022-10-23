package com.ironhack.Bank.controllers.AccountsType;

import com.ironhack.Bank.controllers.DTOs.CheckingDTO;
import com.ironhack.Bank.controllers.DTOs.CreditDTO;
import com.ironhack.Bank.controllers.interfaces.AccountsType.CheckingControllerInterface;
import com.ironhack.Bank.entity.AccountsType.Checking;
import com.ironhack.Bank.entity.AccountsType.CreditCards;
import com.ironhack.Bank.entity.Embeddable.Money;
import com.ironhack.Bank.entity.UsersType.ThirdParty;
import com.ironhack.Bank.services.AccountsType.CheckingService;
import com.ironhack.Bank.services.AccountsType.CreditCardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CheckingController implements CheckingControllerInterface {
    @Autowired
    CheckingService checkingService;

    @PostMapping("/checking/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Checking addChecking(@RequestBody CheckingDTO checking)  {
        return checkingService.addChecking(checking);

    }


    @PatchMapping("/checking/patch/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Checking updateCheckingBalance(@PathVariable Long id, @RequestBody Money balance) {
        return checkingService.updateCheckingBalance(id, balance);
    }

    @DeleteMapping("/checking/delete/")
    @ResponseStatus(HttpStatus.OK)
    public Checking deleteChecking(@RequestBody CheckingDTO checkingDTO) {
        return checkingService.deleteChecking(checkingDTO);
    }


    @PutMapping("/checking/put/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Checking updateChecking(@PathVariable Long id, @RequestBody Money balance) {
        return checkingService.updateChecking(id, balance);
    }
    @GetMapping("/checking/getall")
    @ResponseStatus(HttpStatus.OK)
    public List<Checking> getAllChecking(){
        return checkingService.getAllThirdParty();
    }

    @GetMapping("/checking/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Checking getOneChecking(@PathVariable Long id, @RequestBody CheckingDTO checkingDTO){
        return  checkingService.getOneThirdParty(id, checkingDTO);
    }

}
