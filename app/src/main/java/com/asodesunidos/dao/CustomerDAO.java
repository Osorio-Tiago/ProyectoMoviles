package com.asodesunidos.dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.asodesunidos.entity.Customer;

@Dao
public interface CustomerDAO {

    @Insert
    public abstract Customer insert(Customer customer);

}
