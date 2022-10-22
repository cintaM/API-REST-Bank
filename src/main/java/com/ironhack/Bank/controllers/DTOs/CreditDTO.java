package com.ironhack.Bank.controllers.DTOs;

import com.ironhack.Bank.enums.Status;
import com.ironhack.Bank.enums.Types;

public class CreditDTO {

    private Long balance;
    private Long primaryOwnerId;
    private Long secondaryOwnerId;
    private double penaltyFee;
    private Long creditLimit;
    private double interestRate;

    private String secretKey;

    private Long minimumBalance;

    private Double monthlyMaintenanceFee;








    public CreditDTO(Long balance, Long primaryOwnerId, Long secondaryOwnerId, double penaltyFee, Long creditLimit, double interestRate) {
        this.balance = balance;
        this.primaryOwnerId = primaryOwnerId;
        this.secondaryOwnerId = secondaryOwnerId;
        this.penaltyFee = penaltyFee;
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }


    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long getPrimaryOwnerId() {
        return primaryOwnerId;
    }

    public void setPrimaryOwnerId(Long primaryOwnerId) {
        this.primaryOwnerId = primaryOwnerId;
    }

    public Long getSecondaryOwnerId() {
        return secondaryOwnerId;
    }

    public void setSecondaryOwnerId(Long secondaryOwnerId) {
        this.secondaryOwnerId = secondaryOwnerId;
    }

    public double getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(Long penaltyFee) {
        this.penaltyFee = penaltyFee;
    }

    public Long getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Long creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setPenaltyFee(double penaltyFee) {
        this.penaltyFee = penaltyFee;
    }






}
