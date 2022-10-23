package com.ironhack.Bank.services;

import com.ironhack.Bank.entity.AccountsType.Accounts;
import com.ironhack.Bank.entity.Embeddable.Money;
import com.ironhack.Bank.entity.Transactions;
import com.ironhack.Bank.repositories.AccountsType.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class TransactionsService {

    @Autowired
    AccountsRepository accountsRepository;

    public Transactions transactionsaccounts(Transactions transactions){
        Accounts source = accountsRepository.findById(transactions.getId1());
        Accounts target = accountsRepository.findOne(transactions.getId1());


        Money currentSourceBalance = source.getBalance();
        Money currentTargetBalance = target.getBalance();

        // Actualizo los salgos de las cuentas de origen y destino
        source.setBalance(currentSourceBalancetransactions.getAmount());
        target.setBalance(currentTargetBalance + totalAmount);
        accountRepository.save(source);
        accountRepository.save(target);

        return transactionRepository.save(transaction);
    }
}
