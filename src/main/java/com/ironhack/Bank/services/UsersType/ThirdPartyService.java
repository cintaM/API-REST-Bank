package com.ironhack.Bank.services.UsersType;

import com.ironhack.Bank.controllers.DTOs.CheckingDTO;
import com.ironhack.Bank.controllers.DTOs.CreditDTO;
import com.ironhack.Bank.entity.AccountsType.Checking;
import com.ironhack.Bank.entity.AccountsType.CreditCards;
import com.ironhack.Bank.entity.Embeddable.Money;
import com.ironhack.Bank.entity.UsersType.Holders;
import com.ironhack.Bank.entity.UsersType.ThirdParty;
import com.ironhack.Bank.repositories.AccountsType.CreditCardsRepository;
import com.ironhack.Bank.respositories.UsersType.HoldersRepository;
import com.ironhack.Bank.respositories.UsersType.ThirdPartyRepository;
import com.ironhack.Bank.services.interfaces.UsersType.ThirdPartyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ThirdPartyService implements ThirdPartyServiceInterface {
    @Autowired
    ThirdPartyRepository thirdPartyRepository;

    public ThirdParty addThirdParty(ThirdParty thirdParty) {
        if (thirdPartyRepository.findById(thirdParty.getId()).isPresent()){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        return thirdPartyRepository.save(thirdParty);
    };


    public ThirdParty deleteThirdParty(Long id) {
        ThirdParty thirdParty = thirdPartyRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return thirdPartyRepository.delete(thirdParty);
    };


    public List<ThirdParty> getAllThirdParty(){
        return thirdPartyRepository.findAll();
    }

    public ThirdParty getOneThirdParty(Long id){
        ThirdParty thirdParty = thirdPartyRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return thirdParty;
    }


}
