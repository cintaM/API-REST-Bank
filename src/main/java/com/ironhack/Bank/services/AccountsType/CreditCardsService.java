package com.ironhack.Bank.services.AccountsType;

import com.ironhack.Bank.controllers.DTOs.CreditDTO;
import com.ironhack.Bank.entity.AccountsType.CreditCards;
import com.ironhack.Bank.entity.Embeddable.Money;
import com.ironhack.Bank.entity.UsersType.Holders;
import com.ironhack.Bank.repositories.AccountsType.CreditCardsRepository;
import com.ironhack.Bank.respositories.UsersType.HoldersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@Service
public class CreditCardsService {
    @Autowired
    CreditCardsRepository creditCardsRepository;

    @Autowired
    HoldersRepository holdersRepository;


    public CreditCards addCreditCards(CreditCards creditCards) {
        if (creditCardsRepository.findById(creditCards.getId()).isPresent()){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        return creditCardsRepository.save(creditCards);
    };

    public CreditCards addCreditCards2(CreditDTO creditCards) {
        Money balance = new Money(BigDecimal.valueOf(creditCards.getBalance()));
        Holders primaryOwner = holdersRepository.findById(creditCards.getPrimaryOwnerId()).get();
        Holders secondaryOwner = null;
        if(creditCards.getSecondaryOwnerId() != null){
            secondaryOwner = holdersRepository.findById(creditCards.getSecondaryOwnerId()).get();
        }
        BigDecimal penaltyFee = BigDecimal.valueOf(creditCards.getPenaltyFee());
        Money creaditLimit = new Money(BigDecimal.valueOf(creditCards.getCreditLimit()));
        BigDecimal interestRate = BigDecimal.valueOf(creditCards.getInterestRate());
        CreditCards creditCards1 = new CreditCards(balance,primaryOwner, secondaryOwner, penaltyFee, creaditLimit, interestRate);
        return creditCardsRepository.save(creditCards1);
    };
/*
        public CreditCards updateCreditCardsBalance(Long id, Money balance) {
        CreditCards creditCard = creditCardsRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        creditCard.setBalance(balance);
        return creditCardsRepository.save(creditCard);

    }

 */
   /*  public Optional<CreditCards> deleteCreditCards(CreditCards creditCards) {
        if (creditCardsRepository.findById(creditCards.getId()).isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return creditCardsRepository.delete();
     };

    */






}
