package com.ironhack.Bank.services.interfaces.AccountsType;

import com.ironhack.Bank.controllers.DTOs.CheckingDTO;
import com.ironhack.Bank.entity.AccountsType.Checking;
import com.ironhack.Bank.entity.AccountsType.CreditCards;
import com.ironhack.Bank.entity.AccountsType.Saving;
import com.ironhack.Bank.entity.Embeddable.Money;

import java.util.List;

public interface CheckingServiceInterface {
    Checking addChecking(CheckingDTO checkingDTO);

    Checking updateCheckingBalance(Long id, Money balance);

    Checking deleteChecking(CheckingDTO checkingDTO);


    Checking getOneChecking(Long id, CheckingDTO checkingDTO);
    List<Checking> getAllChecking();

    Checking updateChecking(Long id, Checking checking);

}
