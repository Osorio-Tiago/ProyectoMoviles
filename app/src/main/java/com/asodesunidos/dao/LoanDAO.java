package com.asodesunidos.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Update;

import com.asodesunidos.entity.Loan;

@Dao
public interface LoanDAO {

    @Insert
    public abstract Loan insert(Loan loan);

    @Update
    public abstract Loan update(Loan loan);

}
