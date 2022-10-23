package com.ironhack.Bank.controllers.interfaces.AccountsType;

import com.ironhack.Bank.controllers.DTOs.CheckingDTO;
import com.ironhack.Bank.controllers.DTOs.CreditDTO;
import com.ironhack.Bank.entity.AccountsType.Checking;
import com.ironhack.Bank.entity.AccountsType.CreditCards;
import com.ironhack.Bank.entity.Embeddable.Money;

import java.util.List;
import java.util.Optional;

public interface CreditCardsControllerInterface {

    CreditCards addCreditCards(CreditDTO creditDTO);

     CreditCards updateCreditCardsBalance(Long id, Long balance);

   void deleteCreditCards(CreditCards creditCards);


    CreditCards  getOneCreditCards(Long id);
    List<CreditCards > getAllCreditCards();

    CreditCards  updateCreditCards(Long id, CreditCards creditCards);

}
