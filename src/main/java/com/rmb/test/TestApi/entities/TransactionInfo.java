package com.rmb.test.TestApi.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "TransactionInfo")
public class TransactionInfo {

    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="txn_seqgen")
    @SequenceGenerator(name="txn_seqgen", sequenceName="txn_SEQ",allocationSize=1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountId", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private AccountInfo accountInfo;
    @Column(name = "accountId")
    @NotNull(message = "please supply the account id;")
    private Long accountId;
    @Column(name = "transactionDate")
    @NotNull(message = "please supply the transaction date")
    private Date transactionDate;
    @Column(name = "transactionValue")
    @NotNull(message = "please supply the transaction value")
    private BigDecimal transactionValue;
    @Column(name = "transactionCurrency")
    @NotBlank(message = "please supply the transaction currency")
    private String transactionCurrency;
    @Column(name = "transactionSource")
    @NotBlank(message = "please supply the transaction source")
    private String transactionSource;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public BigDecimal getTransactionValue() {
        return transactionValue;
    }

    public void setTransactionValue(BigDecimal transactionValue) {
        this.transactionValue = transactionValue;
    }

    public String getTransactionCurrency() {
        return transactionCurrency;
    }

    public void setTransactionCurrency(String transactionCurrency) {
        this.transactionCurrency = transactionCurrency;
    }

    public String getTransactionSource() {
        return transactionSource;
    }

    public void setTransactionSource(String transactionSource) {
        this.transactionSource = transactionSource;
    }

    @Override
    public String toString() {
        return "TransactionInfo{" +
                "id=" + id +
                ", accountInfo=" + accountInfo +
                ", accountId=" + accountId +
                ", transactionDate=" + transactionDate +
                ", transactionValue=" + transactionValue +
                ", transactionCurrency='" + transactionCurrency + '\'' +
                ", transactionSource='" + transactionSource + '\'' +
                '}';
    }
}
