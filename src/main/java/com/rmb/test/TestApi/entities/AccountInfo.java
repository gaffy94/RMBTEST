package com.rmb.test.TestApi.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "AccountInfo")
public class AccountInfo {
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="acct_seqgen")
    @SequenceGenerator(name="acct_seqgen", sequenceName="acct_SEQ",allocationSize=1)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CustomerInfo customer;
    @Column(name = "customerId")
    @NotNull(message = "please supply the CustomerId")
    private Long customerId;
    @Column(name = "accountBalance")
    @NotNull(message = "please supply the Account Balance")
    private BigDecimal accountBalance;
    @Column(name = "PND")
    private char PND = 'N';
    @Column(name = "PNC")
    private char PNC = 'N';
    @Column(name = "isActive")
    private char isActive = 'Y';
    @Column(name = "amountBlocked")
    private BigDecimal amountBlocked;

    @Column(name = "accountCurrency")
    private String accountCurrency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerInfo getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerInfo customer) {
        this.customer = customer;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public char getPND() {
        return PND;
    }

    public void setPND(char PND) {
        this.PND = PND;
    }

    public char getPNC() {
        return PNC;
    }

    public void setPNC(char PNC) {
        this.PNC = PNC;
    }

    public char getIsActive() {
        return isActive;
    }

    public void setIsActive(char isActive) {
        this.isActive = isActive;
    }

    public BigDecimal getAmountBlocked() {
        return amountBlocked;
    }

    public void setAmountBlocked(BigDecimal amountBlocked) {
        this.amountBlocked = amountBlocked;
    }

    public String getAccountCurrency() {
        return accountCurrency;
    }

    public void setAccountCurrency(String accountCurrency) {
        this.accountCurrency = accountCurrency;
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "id=" + id +
                ", customer=" + customer +
                ", customerId=" + customerId +
                ", accountBalance=" + accountBalance +
                ", PND=" + PND +
                ", PNC=" + PNC +
                ", isActive=" + isActive +
                ", amountBlocked=" + amountBlocked +
                ", accountCurrency='" + accountCurrency + '\'' +
                '}';
    }
}
