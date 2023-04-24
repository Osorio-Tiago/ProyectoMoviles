package com.asodesunidos.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Update;

import com.asodesunidos.entity.Saving;

@Dao
public interface SavingDAO {

    @Insert
    public abstract Saving insert(Saving saving);

    @Update
    public abstract Saving update(Saving saving);

}
