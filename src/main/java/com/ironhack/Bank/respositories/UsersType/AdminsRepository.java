package com.ironhack.Bank.respositories.UsersType;

import com.ironhack.Bank.entity.UsersType.Admins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

import java.util.Optional;

@Repository
public interface AdminsRepository extends JpaRepository<Admins, Long> {





}


