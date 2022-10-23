package com.ironhack.Bank.repositories.AccountsType;

import com.ironhack.Bank.entity.AccountsType.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<Accounts, Long> {
}
