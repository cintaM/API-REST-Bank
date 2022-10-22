package com.ironhack.Bank.repositories.AccountsType;

import com.ironhack.Bank.entity.AccountsType.CreditCards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreditCardsRepository extends JpaRepository<CreditCards, Long> {


    //Optional<CreditCards> delete();
}
