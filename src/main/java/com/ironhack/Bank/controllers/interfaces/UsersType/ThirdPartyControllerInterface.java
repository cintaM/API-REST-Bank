package com.ironhack.Bank.controllers.interfaces.UsersType;

import com.ironhack.Bank.controllers.DTOs.CreditDTO;
import com.ironhack.Bank.entity.AccountsType.CreditCards;
import com.ironhack.Bank.entity.Embeddable.Money;
import com.ironhack.Bank.entity.Embeddable.PrimaryAddress;
import com.ironhack.Bank.entity.UsersType.Holders;
import com.ironhack.Bank.entity.UsersType.ThirdParty;

import java.util.List;

public interface ThirdPartyControllerInterface {
   ThirdParty addThirdParty(ThirdParty thirdParty);


    ThirdParty deleteThirdParty();

    ThirdParty getOneThirdParty(Long id, ThirdParty thirdParty);
    List<ThirdParty > getAllThirdParty();

}
