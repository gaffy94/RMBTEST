package com.rmb.test.TestApi.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Entity
@Table(name = "CustomerInfo")
public class CustomerInfo {

    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="cust_seqgen")
    @SequenceGenerator(name="cust_seqgen", sequenceName="cust_SEQ",allocationSize=1)
    private Long id;
    @Column(name = "customerNumber", nullable = false, length = 10)
    private Long customerNumber = random();
    @Column(name = "customerName", nullable = false, length = 255)
    @NotBlank(message = "Please Supply Customer Name")
    private String customerName;
    @Column(name = "customerEmail", nullable = true, length = 100)
    private String customerEmail;
    @Column(name = "customerPhoneNumber", nullable = true, length = 15)
    private String customerPhoneNumber;
    @Column(name = "customerAddress", nullable = false, length = 255)
    @NotBlank(message = "Please Supply Customer Address")
    private String customerAddress;
    @Column(name = "customerBVN", nullable = true, length = 255)
    private String customerBVN;
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"customer"})
    private Set<AccountInfo> accounts = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Long customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerBVN() {
        return customerBVN;
    }

    public void setCustomerBVN(String customerBVN) {
        this.customerBVN = customerBVN;
    }

    public Set<AccountInfo> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<AccountInfo> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "CustomerInfo{" +
                "id=" + id +
                ", customerNumber=" + customerNumber +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerPhoneNumber='" + customerPhoneNumber + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerBVN='" + customerBVN + '\'' +
                ", accounts=" + accounts +
                '}';
    }

    public static Long random(){
        Random rnd = new Random();
        return Long.valueOf(100000 + rnd.nextInt(900000));
    }
}
