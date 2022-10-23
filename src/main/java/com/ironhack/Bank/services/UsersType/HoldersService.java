package com.ironhack.Bank.services.UsersType;

import com.ironhack.Bank.controllers.DTOs.CheckingDTO;
import com.ironhack.Bank.controllers.DTOs.CreditDTO;
import com.ironhack.Bank.entity.AccountsType.Checking;
import com.ironhack.Bank.entity.AccountsType.CreditCards;
import com.ironhack.Bank.entity.Embeddable.Money;
import com.ironhack.Bank.entity.Embeddable.PrimaryAddress;
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



    public Holders addCreditCards(Holders holders) {
        if (holdersRepository.findById(holders.getId()).isPresent()){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        return holdersRepository.save(holders);
    };


    public Holders updateHoldersPrimaryAddress(Long id, PrimaryAddress primaryAddress) {
        Holders holders = holdersRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        holders.setPrimaryAddress(primaryAddress);
        return holdersRepository.save(holders);

    }


    public Holders deleteHolders(Long id) {
        Holders holders = holdersRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return holdersRepository.delete(holders);
    };


    public List<Holders> getAllHolders(){
        return holdersRepository.findAll();
    }

    public Holders getOneHolders(Long id){
        Holders holders = holdersRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return holders;
    }





}







