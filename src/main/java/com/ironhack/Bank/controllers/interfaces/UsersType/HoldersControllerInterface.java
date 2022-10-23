package com.ironhack.Bank.controllers.interfaces.UsersType;

import com.ironhack.Bank.controllers.DTOs.CreditDTO;
import com.ironhack.Bank.entity.AccountsType.CreditCards;
import com.ironhack.Bank.entity.Embeddable.Money;
import com.ironhack.Bank.entity.Embeddable.PrimaryAddress;
import com.ironhack.Bank.entity.UsersType.Holders;

import java.util.List;

public interface HoldersControllerInterface {

    Holders addHolder(Holders holders);

    Holders updateHolderPrimaryAddress(Long id, PrimaryAddress primaryAddress);

    Holders deleteHolder();

    Holders  getOneHolder(Long id, Holders holders);
    List<Holders > getAllHolder();

}
