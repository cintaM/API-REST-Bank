package com.ironhack.Bank.controllers.interfaces.AccountsType;

import com.ironhack.Bank.controllers.DTOs.CreditDTO;
import com.ironhack.Bank.controllers.DTOs.SavingDTO;
import com.ironhack.Bank.entity.AccountsType.CreditCards;
import com.ironhack.Bank.entity.AccountsType.Saving;
import com.ironhack.Bank.entity.Embeddable.Money;

import java.util.List;

public interface SavingControllerInterface {

    Saving addSaving(SavingDTO savingDTO);

    Saving updateSavingBalance(Long id, Long balance);

    void deleteSaving(Saving saving);

    Saving  getOneSaving(Long id, Saving saving);
    List< Saving > getAllSaving();

    Saving  updateSaving(Long id);

}
