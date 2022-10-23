package com.ironhack.Bank.services.UsersType;

import com.ironhack.Bank.controllers.DTOs.CheckingDTO;
import com.ironhack.Bank.controllers.DTOs.CreditDTO;
import com.ironhack.Bank.entity.AccountsType.Checking;
import com.ironhack.Bank.entity.AccountsType.CreditCards;
import com.ironhack.Bank.entity.Embeddable.Money;
import com.ironhack.Bank.entity.UsersType.Holders;
import com.ironhack.Bank.repositories.AccountsType.CreditCardsRepository;
import com.ironhack.Bank.respositories.UsersType.HoldersRepository;
import com.ironhack.Bank.services.interfaces.UsersType.HoldersServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@Service
public class HoldersService implements HoldersServiceInterface {



    @Autowired
    HoldersRepository holdersRepository;



    public CreditCards addCreditCards(CreditCards creditCards) {
        if (creditCardsRepository.findById(creditCards.getId()).isPresent()){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        return creditCardsRepository.save(creditCards);
    };

    public Checking addChecking(CheckingDTO checkingDTO) {
        Money balance = new Money(BigDecimal.valueOf(checkingDTO.getBalance()));
        Holders primaryOwner = holdersRepository.findById(checkingDTO.getPrimaryOwnerId()).get();
        Holders secondaryOwner = null;
        if(checkingDTO.getSecondaryOwnerId() != null){
            secondaryOwner = holdersRepository.findById(checkingDTO.getSecondaryOwnerId()).get();
        }
        BigDecimal penaltyFee = BigDecimal.valueOf(checkingDTO.getPenaltyFee());
        Money creditLimit = new Money(BigDecimal.valueOf(checkingDTO.getCreditLimit()));
        BigDecimal interestRate = BigDecimal.valueOf(checkingDTO.getInterestRate());
        Money minimumbBalance = new Money(BigDecimal.valueOf(checkingDTO.getMinimumBalance()));
        BigDecimal monthlyMaintenanceFee = BigDecimal.valueOf(checkingDTO.getMonthlyMaintenanceFee());
        Checking checking = new Checking(balance, primaryOwner, primaryOwner, penaltyFee, checkingDTO.getSecretKey(), minimumbBalance, monthlyMaintenanceFee, checkingDTO.getStatus(), checkingDTO.getType());
        return checkingRepository.save(checking);
    };

    public Checking updateCheckingBalance(Long id, Money balance) {
        Checking checking = checkingRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        checking.setBalance(balance);
        return checkingRepository.save(checking);

    }


    public Checking deleteChecking(Long id) {
        Checking checking = checkingRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return checkingRepository.delete(checking);
    };


    public List<Checking> getAllChecking(){
        return checkingRepository.findAll();
    }

    public Checking getOneChecking(Long id){
        Checking checking = checkingRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return checking;
    }





}







