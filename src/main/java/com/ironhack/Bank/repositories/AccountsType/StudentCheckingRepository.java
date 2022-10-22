package com.ironhack.Bank.repositories.AccountsType;

import com.ironhack.Bank.entity.AccountsType.StudentChecking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCheckingRepository extends JpaRepository<StudentChecking, Long> {
}
