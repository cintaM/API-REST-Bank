package com.ironhack.Bank.controllers.UsersType;

import com.ironhack.Bank.controllers.interfaces.UsersType.HoldersControllerInterface;
import com.ironhack.Bank.entity.Embeddable.PrimaryAddress;
import com.ironhack.Bank.entity.UsersType.Holders;
import com.ironhack.Bank.services.UsersType.HoldersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HoldersController implements HoldersControllerInterface {


    @Autowired
    HoldersService holdersService;



    @PostMapping("/holder/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Holders addHolder(@RequestBody Holders holders)  {
        return holdersService.addHolder(holders);

    }


    @PatchMapping("/holder/patch/{id}")
    public Holders updateHolderPrimaryAddress(@PathVariable Long id, @RequestBody PrimaryAddress primaryAddress) {
        return holdersService.updateHolderPrimaryAddress(id, primaryAddress);
    }

    @DeleteMapping("/holder/delete/")
    public void deleteHolder(@RequestBody Holders holders) {
        holdersService.deleteHolder(holders);
    }


  @GetMapping("/holder/getall")
    public List<Holders> getAllHolder(){
        return holdersService.getAllHolder();
  }

  @GetMapping("/holder/get/{id}")
    public Holders getOneHolder(@PathVariable Long id, @RequestBody Holders holders){
        return  holdersService.getOneHolder(id, holders);
  }

}

