package com.ironhack.Bank.controllers.UsersType;

import com.ironhack.Bank.controllers.DTOs.CreditDTO;
import com.ironhack.Bank.controllers.interfaces.UsersType.ThirdPartyControllerInterface;
import com.ironhack.Bank.entity.AccountsType.CreditCards;
import com.ironhack.Bank.entity.Embeddable.Money;
import com.ironhack.Bank.entity.Embeddable.PrimaryAddress;
import com.ironhack.Bank.entity.UsersType.Holders;
import com.ironhack.Bank.entity.UsersType.ThirdParty;
import com.ironhack.Bank.services.AccountsType.CreditCardsService;
import com.ironhack.Bank.services.UsersType.HoldersService;
import com.ironhack.Bank.services.UsersType.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ThirdPartyController implements ThirdPartyControllerInterface {
    @Autowired
    ThirdPartyService thirdPartyService;



    @PostMapping("/thirdparty/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ThirdParty addThirdParty(@RequestBody ThirdParty thirdParty)  {
        return thirdPartyService.addThirdParty(thirdParty);

    }


    @DeleteMapping("/thirdparty/delete/")
    public void deleteThirdParty(@RequestBody ThirdParty thirdParty) {
         thirdPartyService.deleteThirdParty(thirdParty);
    }


    @GetMapping("/thirdparty/getall")
    public List<ThirdParty> getAllThirdParty(){
        return thirdPartyService.getAllThirdParty();
    }

    @GetMapping("/thirdparty/get/{id}")
    public ThirdParty getOneThirdParty(@PathVariable Long id, @RequestBody ThirdParty thirdParty){
        return  thirdPartyService.getOneThirdParty(id, thirdParty);
    }

}
