package com.ironhack.Bank.entity.AccountsType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.Bank.entity.UsersType.Admins;
import com.ironhack.Bank.entity.Embeddable.Money;
import com.ironhack.Bank.entity.UsersType.Holders;
import com.ironhack.Bank.entity.UsersType.Users;
import com.ironhack.Bank.enums.Status;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
public class Saving extends Accounts {

    private String secretKey;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "minimum_balance")),
            @AttributeOverride(name = "currency", column = @Column(name = "minimum_balance_currency"))
    })

    private Money minimumBalance  ;
    @Enumerated(EnumType.STRING)
    private Status status;


    @DecimalMax("0.5")
    private BigDecimal interestRate;



    public Saving() {
    }

    public Saving(Money balance, Holders primaryOwner, Holders secondaryOwner, BigDecimal penaltyFee, String secretKey, Money minimumBalance, Status status,BigDecimal interestRate) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee);
        this.secretKey = secretKey;
        this.minimumBalance = minimumBalance;
        this.status = status;
        this.interestRate = interestRate;
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
        this.minimumBalance = new Money(BigDecimal.valueOf(100)) ;
    }



    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = BigDecimal.valueOf(0.0025);
    }
}
