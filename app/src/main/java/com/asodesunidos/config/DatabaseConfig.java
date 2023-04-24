package com.asodesunidos.config;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.asodesunidos.dao.CrudDAO;
import com.asodesunidos.dao.UserDAO;
import com.asodesunidos.dao.UserDAO_Impl;
import com.asodesunidos.entity.User;


@Database(entities = {User.class}, version = 1)
public abstract class DatabaseConfig extends RoomDatabase {

    public abstract UserDAO getUserDAO();




}
