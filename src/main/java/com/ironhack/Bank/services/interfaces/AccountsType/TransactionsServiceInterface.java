package com.ironhack.Bank.services.interfaces.AccountsType;

import com.ironhack.Bank.entity.Transactions;

import java.util.List;

public interface TransactionsServiceInterface {
    Transactions addTransaction (Transactions  transactions);


    Transactions  deleteTransaction();

    Transactions   getOneTransactions (Long id,  Transactions transactions);

    List<Transactions> getAllHolder();

}
