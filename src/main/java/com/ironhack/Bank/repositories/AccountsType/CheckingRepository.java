package com.ironhack.Bank.repositories.AccountsType;

import com.ironhack.Bank.entity.AccountsType.Checking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingRepository extends JpaRepository<Checking, Long> {

}
