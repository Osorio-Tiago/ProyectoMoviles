package com.asodesunidos.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


@Entity(tableName = "loans", foreignKeys = @ForeignKey(entity = User.class,
        parentColumns = "uid",
        childColumns = "customerId"))
public class Loan {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo (name = "loanId")
    @NonNull
    private int loanId;

    @ColumnInfo (name = "loanType")
    @NonNull
    private String loantype; // Hipotecario - Educacion - Personal - Viajes

    @ColumnInfo (name = "customerId")
    @NonNull
    private int customerId;

    @ColumnInfo (name = "totalCredit")
    @NonNull
    private float totalCredit;

    @ColumnInfo (name = "period")
    @NonNull
    private int period; // 3 - 5 - 10

    @ColumnInfo (name = "percentage")
    @NonNull
    private float percentage;  //Hipotecario = 7.5% - Educacion = 8% - Personal = 10% - Viajes = 12%

    public Loan(int loanId, @NonNull String loantype, int customerId, float totalCredit, int period, float percentage) {
        this.loanId = loanId;
        this.loantype = loantype;
        this.customerId = customerId;
        this.totalCredit = totalCredit;
        this.period = period;
        this.percentage = percentage;
    }

    public Loan() {
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    @NonNull
    public String getLoantype() {
        return loantype;
    }

    public void setLoantype(@NonNull String loantype) {
        this.loantype = loantype;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public float getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(float totalCredit) {
        this.totalCredit = totalCredit;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }
}