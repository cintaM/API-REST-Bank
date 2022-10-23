package com.ironhack.Bank.services.AccountsType;

import com.ironhack.Bank.controllers.DTOs.SavingDTO;
import com.ironhack.Bank.entity.AccountsType.Saving;
import com.ironhack.Bank.entity.Embeddable.Money;
import com.ironhack.Bank.entity.UsersType.Holders;
import com.ironhack.Bank.repositories.AccountsType.SavingRepository;
import com.ironhack.Bank.respositories.UsersType.HoldersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SavingService {
    @Autowired
    SavingRepository savingRepository;

    @Autowired
    HoldersRepository holdersRepository;


    public Saving addSaving(SavingDTO savingDTO) {
        Money balance = new Money(BigDecimal.valueOf(savingDTO.getBalance()));
        Holders primaryOwner = holdersRepository.findById(savingDTO.getPrimaryOwnerId()).get();
        Holders secondaryOwner = null;
        if(savingDTO.getSecondaryOwnerId() != null){
            secondaryOwner = holdersRepository.findById(savingDTO.getSecondaryOwnerId()).get();
        }
        BigDecimal penaltyFee = BigDecimal.valueOf(savingDTO.getPenaltyFee());
        Money creditLimit = new Money(BigDecimal.valueOf(savingDTO.getCreditLimit()));
        BigDecimal interestRate = BigDecimal.valueOf(savingDTO.getInterestRate());
        Money minimumbBalance = new Money(BigDecimal.valueOf(savingDTO.getMinimumBalance()));
        BigDecimal monthlyMaintenanceFee = BigDecimal.valueOf(savingDTO.getMonthlyMaintenanceFee());
        Saving saving = new Saving(balance, primaryOwner, primaryOwner, penaltyFee, savingDTO.getSecretKey(), minimumbBalance, savingDTO.getStatus(), interestRate);
        return savingRepository.save(saving);
    };

    public Saving updateSavingBalance(Long id, Money balance) {
        Saving checking = savingRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        checking.setBalance(balance);
        return savingRepository.save(checking);

    }


    public Saving deleteSaving(Long id) {
        Saving saving = savingRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return savingRepository.delete(saving);
    };


    public List<Saving> getAllSaving(){
        return savingRepository.findAll();
    }

    public Saving getOneSaving(Long id, Saving saving){
        Saving saving = savingRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return saving;
    }



}
