package com.ironhack.Bank.services.AccountsType;

import com.ironhack.Bank.controllers.DTOs.CheckingDTO;
import com.ironhack.Bank.controllers.DTOs.CreditDTO;
import com.ironhack.Bank.entity.AccountsType.Checking;
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
import java.util.List;

@Service
public class CreditCardsService {
    @Autowired
    CreditCardsRepository creditCardsRepository;

    @Autowired
    HoldersRepository holdersRepository;



    public CreditCards addCreditCards(CreditDTO creditCards) {
        Money balance = new Money(BigDecimal.valueOf(creditCards.getBalance()));
        Holders primaryOwner = holdersRepository.findById(creditCards.getPrimaryOwnerId()).get();
        Holders secondaryOwner = null;
        if(creditCards.getSecondaryOwnerId() != null){
            secondaryOwner = holdersRepository.findById(creditCards.getSecondaryOwnerId()).get();
        }
        BigDecimal penaltyFee = BigDecimal.valueOf(creditCards.getPenaltyFee());
        Money creditLimit = new Money(BigDecimal.valueOf(creditCards.getCreditLimit()));
        BigDecimal interestRate = BigDecimal.valueOf(creditCards.getInterestRate());
        CreditCards creditCards1 = new CreditCards(balance, primaryOwner, secondaryOwner, penaltyFee, creditLimit, interestRate);
        return creditCardsRepository.save(creditCards1);
    };

    public CreditCards updateCreditCardsBalance(Long id, Money balance) {
        CreditCards creditCards = creditCardsRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        creditCards.setBalance(balance);
        return creditCardsRepository.save(creditCards);

    }


    public CreditCards deleteCreditCards(Long id) {
        CreditCards creditCards = creditCardsRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return creditCardsRepository.delete(creditCards);
    };


    public List<CreditCards> getAllCreditCards(){
        return creditCardsRepository.findAll();
    }

    public CreditCards getOneCreditCards(Long id){
        CreditCards creditCards = creditCardsRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return creditCards;
    }






}
