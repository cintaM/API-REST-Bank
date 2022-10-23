package com.ironhack.Bank.services.AccountsType;

import com.ironhack.Bank.controllers.DTOs.SavingDTO;
import com.ironhack.Bank.entity.AccountsType.Checking;
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
        Saving saving = savingRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        saving.setBalance(balance);
        return savingRepository.save(saving;

    }


    public void deleteSaving(Saving saving) {
        if (!savingRepository.findById(saving.getId()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }

        savingRepository.delete(saving);
    }



    public List<Saving> getAllChecking(){
        return savingRepository.findAll();
    }

    public Saving getOneChecking(Long id){
        return savingRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    public Saving updateChecking(Long id, Saving saving) {
        if (!savingRepository.findById(id).isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        saving.setId(id);
        return savingRepository.save(saving);
    }



}
