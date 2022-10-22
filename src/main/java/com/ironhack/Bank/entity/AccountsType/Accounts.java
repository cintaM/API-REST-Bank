package com.ironhack.Bank.entity.AccountsType;


import com.ironhack.Bank.entity.Embeddable.Money;
import com.ironhack.Bank.entity.UsersType.Holders;
import com.ironhack.Bank.entity.UsersType.Users;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "balance")),
            @AttributeOverride(name = "currency", column = @Column(name = "balance_currency"))
    })
    private Money balance;
    @ManyToOne
    @JoinColumn(name = "primary_owner_id")
    private Holders primaryOwner;
    @Nullable
    @ManyToOne
    @JoinColumn(name = "secondary_owner_id")
    private Holders secondaryOwner;
    private BigDecimal penaltyFee;
    private LocalDate creationDate;

    public Accounts( Money balance, Holders primaryOwner, Holders secondaryOwner, BigDecimal penaltyFee) {
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
        this.penaltyFee = penaltyFee;
        this.creationDate = LocalDate.now();
    }

    public Accounts() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public Users getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(Holders primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public Users getSecondaryOwner() {
        return secondaryOwner;
    }

    public void setSecondaryOwner(Holders secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
    }

    public BigDecimal getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(BigDecimal penaltyFee) {
        this.penaltyFee = penaltyFee;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
