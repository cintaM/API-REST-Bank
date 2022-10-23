package com.ironhack.Bank.services.interfaces.AccountsType;

import com.ironhack.Bank.controllers.DTOs.CreditDTO;
import com.ironhack.Bank.entity.AccountsType.CreditCards;
import com.ironhack.Bank.entity.Embeddable.Money;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CreditCardsServiceInterface {
    CreditCards addCreditCards(CreditDTO creditDTO);

    CreditCards updateCreditCardsBalance(Long id, Money balance);

    CreditCards deleteCreditCards(CreditCards creditCards);


    CreditCards  getOneCreditCards(Long id, CreditDTO creditDTO);
    List<CreditCards > getAllCreditCards();

    CreditCards  updateCreditCars(Long id, Money balance);


}
