package com.faroti.petshotel.model.repository;

import android.content.Context;

import com.faroti.petshotel.model.database.PetDatabase;
import com.faroti.petshotel.model.database.dao.UserDao;
import com.faroti.petshotel.model.database.entities.User;

public class UserRepository {

    private UserDao userDao ;

    public UserRepository(Context context) {
        userDao = PetDatabase.getDatabase(context).getUserDao();
        loadInitialDatabase();
    }


    public void newUser(String name, String email, String password, String cellPhone){
        userDao.insert(
                new User(name, email, password, cellPhone)
        );
    }


    private void loadInitialDatabase() {
        userDao.insert(
                new User("Jose Pacheco", "jfpacheco11@gmail.com", "12345678" , "1234567890"),
                new User("Usuario Prueba", "test@gmail.com", "87654321", "1234567890")
        );
    }

    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }
}
