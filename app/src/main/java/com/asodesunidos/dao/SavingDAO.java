/*package com.asodesunidos.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.asodesunidos.entity.Saving;

import java.util.List;

@Dao
public interface SavingDAO extends CrudDAO<Saving>{

    @Query("SELECT * FROM savings")
    LiveData<List<Saving>> getAllSavings();

    @Query("SELECT * FROM savings WHERE id = :savingsId")
    LiveData<Saving> getSavingsById(int savingsId);
}
*/