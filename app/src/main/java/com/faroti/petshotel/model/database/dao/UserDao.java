package com.faroti.petshotel.model.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.faroti.petshotel.model.database.entities.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE email = :email")
    User getUserByEmail(String email);

    @Insert
    void insert(User...users);

    @Delete
    void delete(User user);

}
