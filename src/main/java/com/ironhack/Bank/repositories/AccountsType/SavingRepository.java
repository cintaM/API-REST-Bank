package com.ironhack.Bank.repositories.AccountsType;

import com.ironhack.Bank.entity.AccountsType.Saving;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingRepository extends JpaRepository<Saving, Long> {
}
