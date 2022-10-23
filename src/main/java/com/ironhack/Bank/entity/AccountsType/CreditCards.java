package com.ironhack.Bank.entity.AccountsType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.Bank.entity.UsersType.Admins;
import com.ironhack.Bank.entity.Embeddable.Money;
import com.ironhack.Bank.entity.UsersType.Holders;
import com.ironhack.Bank.entity.UsersType.Users;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
public class CreditCards extends Accounts {
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "credit_limit")),
            @AttributeOverride(name = "currency", column = @Column(name = "credit_limit_currency"))
    })
    @NotNull
    private Money creditLimit;

    @DecimalMax("0.2")
   @DecimalMin("0.1")
    private BigDecimal interestRate;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "admins_id")
    Admins admins;


    public CreditCards() {
    }

    public CreditCards(Money balance, Holders primaryOwner, Holders secondaryOwner, BigDecimal penaltyFee, Money creditLimit, BigDecimal interestRate) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee);
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }



    public Money getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Money creditLimit) {
        this.creditLimit = new Money(BigDecimal.valueOf(100));
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }


}
