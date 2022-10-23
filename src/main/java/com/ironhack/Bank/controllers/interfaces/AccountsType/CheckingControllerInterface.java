package com.ironhack.Bank.controllers.interfaces.AccountsType;

import com.ironhack.Bank.controllers.DTOs.CheckingDTO;
import com.ironhack.Bank.entity.AccountsType.Checking;
import com.ironhack.Bank.entity.AccountsType.CreditCards;
import com.ironhack.Bank.entity.Embeddable.Money;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CheckingControllerInterface {

    Checking addChecking(CheckingDTO checkingDTO);

    Checking updateCheckingBalance(Long id, Money balance);

    Checking deleteChecking(CheckingDTO checkingDTO);


    Checking getOneChecking(Long id, CheckingDTO checkingDTO);
    List<Checking> getAllChecking();

    Checking updateChecking(Long id, Money balance);

}
