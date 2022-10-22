package com.ironhack.Bank.services.interfaces.AccountsType;

import com.ironhack.Bank.entity.AccountsType.CreditCards;
import com.ironhack.Bank.entity.Embeddable.Money;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CreditCardsServiceInterface {

    CreditCards addCreditCards(CreditCards creditCards);
/*
    Optional<CreditCards> updateCreditCardsBalance(Long id, Money balance);

    Optional<CreditCards> deleteCreditCards(CreditCards creditCards);

 */



}
