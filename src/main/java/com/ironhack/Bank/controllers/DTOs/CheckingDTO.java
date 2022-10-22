package com.ironhack.Bank.controllers.DTOs;

import com.ironhack.Bank.enums.Status;
import com.ironhack.Bank.enums.Types;

public class CheckingDTO {
    private Long balance;
    private Long primaryOwnerId;
    private Long secondaryOwnerId;
    private double penaltyFee;
    private Long creditLimit;
    private double interestRate;

    private String secretKey;

    private Long minimumBalance;

    private Double monthlyMaintenanceFee;

    private Status status;

    private Type type;

    private Long holderId;



    public AccountDTO(Long balance, Long primaryOwnerId, Long secondaryOwnerId, double penaltyFee, Long creditLimit, double interestRate) {
        this.balance = balance;
        this.primaryOwnerId = primaryOwnerId;
        this.secondaryOwnerId = secondaryOwnerId;
        this.penaltyFee = penaltyFee;
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }

   /* public AccountDTO(Long balance, Long primaryOwnerId, Long secondaryOwnerId, double penaltyFee, String secretKey, Long minimumBalance, double monthlyMaintenanceFee, Status status, Type type) {
        this.balance = balance;
        this.primaryOwnerId = primaryOwnerId;
        this.secondaryOwnerId = secondaryOwnerId;
        this.penaltyFee = penaltyFee;
        this.secretKey = secretKey;
        this.minimumBalance = minimumBalance;
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
        this.status = status;
        this.type = type;
    }
    public AccountDTO(Long balance, Long primaryOwnerId, Long secondaryOwnerId, double penaltyFee, String secretKey, Long minimumBalance, Status status, double interestRate) {
        this.balance = balance;
        this.primaryOwnerId = primaryOwnerId;
        this.secondaryOwnerId = secondaryOwnerId;
        this.penaltyFee = penaltyFee;
        this.secretKey = secretKey;
        this.minimumBalance = minimumBalance;
        this.status = status;
        this.interestRate = interestRate;
    }
    public AccountDTO(Long balance, Long primaryOwnerId, Long secondaryOwnerId, double penaltyFee, String secretKey, Status status, Type type) {
        this.balance = balance;
        this.primaryOwnerId = primaryOwnerId;
        this.secondaryOwnerId = secondaryOwnerId;
        this.penaltyFee = penaltyFee;
        this.secretKey = secretKey;
        this.status = status;
        this.type = type;
    }
    */

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

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public Long getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(Long minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

 /*   public double getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }
    public void setMonthlyMaintenanceFee(double monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }
  */

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }


}
}
