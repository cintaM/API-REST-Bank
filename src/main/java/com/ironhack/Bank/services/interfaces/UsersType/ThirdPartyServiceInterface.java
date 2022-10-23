package com.ironhack.Bank.services.interfaces.UsersType;

import com.ironhack.Bank.entity.AccountsType.CreditCards;
import com.ironhack.Bank.entity.UsersType.ThirdParty;

import java.util.List;

public interface ThirdPartyServiceInterface {
    ThirdParty addThirdParty(ThirdParty thirdParty);


    ThirdParty deleteThirdParty();

    ThirdParty getOneThirdParty(Long id, ThirdParty thirdParty);
    List<ThirdParty > getAllThirdParty();
}
