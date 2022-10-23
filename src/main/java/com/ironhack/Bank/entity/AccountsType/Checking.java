package com.ironhack.Bank.entity.AccountsType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.Bank.entity.UsersType.Admins;
import com.ironhack.Bank.entity.Embeddable.Money;
import com.ironhack.Bank.entity.UsersType.Holders;
import com.ironhack.Bank.entity.UsersType.Users;
import com.ironhack.Bank.enums.Status;
import com.ironhack.Bank.enums.Types;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
public class Checking extends Accounts {

    private String secretKey;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "minimum_balance")),
            @AttributeOverride(name = "currency", column = @Column(name = "minimum_balance_currency"))
    })
    private Money minimumBalance ;
    private BigDecimal monthlyMaintenanceFee;
    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Types types;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "admins_id")
    Admins admins;


    public Checking() {
    }

    public Checking(Money balance, Holders primaryOwner, Holders secondaryOwner, BigDecimal penaltyFee, String secretKey, Money minimumBalance, BigDecimal monthlyMaintenanceFee, Status status, Types types) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee);
        this.secretKey = secretKey;
        this.minimumBalance = minimumBalance;
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
        this.status = status;
        this.types = types;
    }


    public Checking(Money balance, Holders primaryOwner, Holders secondaryOwner, BigDecimal penaltyFee, String secretKey, Money minimumBalance, Status status, Types types) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee);
        this.secretKey = secretKey;
        this.minimumBalance = minimumBalance;
        this.status = status;
        this.types = types;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }


    public Money getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(Money minimumBalance) {
        this.minimumBalance = new Money(BigDecimal.valueOf(250));
    }

    public BigDecimal getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    public void setMonthlyMaintenanceFee(BigDecimal monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = BigDecimal.valueOf(12);
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
