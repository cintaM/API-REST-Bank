package com.ironhack.Bank.entity.UsersType;


import antlr.collections.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.Bank.entity.AccountsType.Accounts;
import com.ironhack.Bank.entity.Embeddable.PrimaryAddress;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Holders extends Users {


    private LocalDate birth;

    @Embedded
    private PrimaryAddress primaryAddress;
    @Nullable
    private String mailingAddress;

    @OneToMany(mappedBy = "primaryOwner")
    @JsonIgnore
    private List<Accounts> primaryList = new ArrayList<>();

    @OneToMany(mappedBy = "secondaryOwner")
    @JsonIgnore
    private List<Accounts> secondaryList = new ArrayList<>();





    public Holders(String name, LocalDate birth, PrimaryAddress primaryAddress, String mailingAddress) {
        super(name);
        this.birth = birth;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
    }


    public Holders() {
    }



    public List<Accounts> getPrimaryList() {
        return primaryList;
    }

    public void setPrimaryList(List<Accounts> primaryList) {
        this.primaryList = primaryList;
    }

    public List<Accounts> getSecondaryList() {
        return secondaryList;
    }

    public void setSecondaryList(List<Accounts> secondaryList) {
        this.secondaryList = secondaryList;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public PrimaryAddress getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(PrimaryAddress primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }
}
