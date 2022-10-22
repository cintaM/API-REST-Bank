package com.ironhack.Bank.controllers.UsersType;

import com.ironhack.Bank.controllers.interfaces.UsersType.AdminsControllerInterface;
import com.ironhack.Bank.respositories.UsersType.AdminsRepository;
import com.ironhack.Bank.services.AccountsType.CheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminsController implements AdminsControllerInterface {

    @Autowired
    AdminsRepository adminsRepository;

    @Autowired
    CheckingService checkingRepository;


  /*  @PostMapping("/checking")
    @ResponseStatus(HttpStatus.CREATED)
    public Optional<Checking> addChecking(@RequestBody Checking checking) {
        return Optional.ofNullable(checkingRepository.addChecking(checking));
    }

   */



}
