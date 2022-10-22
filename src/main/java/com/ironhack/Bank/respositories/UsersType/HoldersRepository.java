package com.ironhack.Bank.respositories.UsersType;

import com.ironhack.Bank.entity.UsersType.Holders;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.Optional;

@Repository
public interface HoldersRepository extends JpaRepository<Holders, Long> {



}
