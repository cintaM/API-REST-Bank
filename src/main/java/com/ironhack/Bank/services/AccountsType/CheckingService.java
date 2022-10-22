package com.ironhack.Bank.services.AccountsType;

import com.ironhack.Bank.repositories.AccountsType.CheckingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckingService {

    @Autowired
    CheckingRepository checkingRepository;


}
