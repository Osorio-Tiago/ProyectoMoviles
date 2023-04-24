package com.asodesunidos.entity;

import androidx.room.PrimaryKey;

public class Loan {

    @PrimaryKey
    private int uid;

    private LoanType type;

    private Customer customer;

    private int period;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public LoanType getType() {
        return type;
    }

    public void setType(LoanType type) {
        this.type = type;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }
}
