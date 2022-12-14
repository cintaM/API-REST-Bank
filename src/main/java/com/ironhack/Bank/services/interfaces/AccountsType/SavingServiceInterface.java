package com.ironhack.Bank.services.interfaces.AccountsType;

import com.ironhack.Bank.controllers.DTOs.SavingDTO;
import com.ironhack.Bank.entity.AccountsType.CreditCards;
import com.ironhack.Bank.entity.AccountsType.Saving;
import com.ironhack.Bank.entity.Embeddable.Money;

import java.util.List;

public interface SavingServiceInterface {
    Saving addSaving(SavingDTO savingDTO);

    Saving updateSavingBalance(Long id, Money balance);

    Saving deleteSaving();

    Saving  getOneSaving(Long id, SavingDTO savingDTO);
    List< Saving > getAllSaving();

    Saving  updateSaving(Long id, Saving saving);

}
