package com.ironhack.Bank.controllers.interfaces.AccountsType;

import com.ironhack.Bank.entity.AccountsType.CreditCards;

import java.util.Optional;

public interface CreditCardsControllerInterface {

    CreditCards addCreditCards(CreditCards creditCards);

     CreditCards updateCreditCardsBalance(Long id, Money balance);

    CreditCards> deleteCreditCards(CreditCards creditCards);




}
