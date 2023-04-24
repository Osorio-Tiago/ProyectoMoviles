package com.asodesunidos.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Update;

import com.asodesunidos.entity.LoanType;

@Dao
public interface LoanTypeDAO {

    @Insert
    public abstract LoanType insert(LoanType loanType);

    @Update
    public abstract LoanType update(LoanType loanType);

}
