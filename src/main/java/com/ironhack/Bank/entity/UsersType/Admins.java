package com.ironhack.Bank.entity.UsersType;

import com.ironhack.Bank.entity.AccountsType.Checking;
import com.ironhack.Bank.entity.AccountsType.CreditCards;
import com.ironhack.Bank.entity.AccountsType.Saving;

import javax.persistence.*;
import java.util.List;
@Entity
public class Admins extends Users {
    public Admins(String name) {
        super(name);
    }

    public Admins() {
    }

    //    @OneToMany(mappedBy = "admins")
//    private List<Checking> checkingList;
//
//    @OneToMany(mappedBy = "admins")
//    private List<Saving> savingList;
//
//    @OneToMany(mappedBy = "admins")
//    private List<CreditCards> creditCardsList;
//
//    @OneToMany(mappedBy = "admins")
//    private List<ThirdParty> thirdPartyList;







}
