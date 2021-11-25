package com.faroti.petshotel.model.repository;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;

import com.faroti.petshotel.model.database.PetDatabase;
import com.faroti.petshotel.model.database.dao.UserDao;
import com.faroti.petshotel.model.database.entities.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserRepository {

    private final static Boolean USE_DATABASE = Boolean.FALSE;

    private UserDao userDao ;

    private DatabaseReference userRef;

    public UserRepository(Context context) {
        userDao = PetDatabase.getDatabase(context).getUserDao();

        FirebaseDatabase database = FirebaseDatabase.getInstance();  //crea la conexión a la BD
        userRef = database.getReference("user");

        loadInitalDatabase();
    }

    private void loadInitalDatabase() {
        if (USE_DATABASE) {
            userDao.insert(
                    new User("Yeison Castaño", "yefer08@gmail.com", "yeison123"),
                    new User("Usuario Prueba", "test@gmail.com", "87654321")
            );
        } else {
            userRef.setValue("Hola 123456");
        }
    }
        public User getUserByEmail(String email) {
        if (USE_DATABASE){
            return userDao.getUserByEmail(email);
        } else {
            // usar FireBase
            // leer de Bd
            userRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    String value = dataSnapshot.getValue(String.class);
                    Log.d(UserRepository.class.getSimpleName(), "value is: " + value);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    Log.w(UserRepository.class.getSimpleName(), "Failed to read value", error.toException());
                }
            });

        }
        return null;
    }


    private User getUserByEmailDB(String email) {
        return userDao.getUserByEmail(email);
    }
}
