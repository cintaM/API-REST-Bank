package com.ironhack.Bank.controllers.interfaces;

import com.ironhack.Bank.entity.Transactions;
import com.ironhack.Bank.entity.UsersType.Holders;

import java.util.List;

public interface TransactionsControllerIntefaces {

    Transactions addTransaction ( Transactions  transactions);


    Transactions  deleteTransaction();

    Transactions   getOneTransactions (Long id,  Transactions transactions);

    List<Transactions> getAllHolder();
}
