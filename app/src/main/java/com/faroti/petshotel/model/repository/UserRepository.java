package com.faroti.petshotel.model.repository;

import android.content.Context;
import android.util.Log;

import com.faroti.petshotel.model.database.PetDatabase;
import com.faroti.petshotel.model.database.dao.UserDao;
import com.faroti.petshotel.model.database.entities.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class UserRepository {
    private final static Boolean USE_DATABASE_LOCAL = Boolean.FALSE;
    private UserDao userDao ;
    private DatabaseReference userRef;
    //public FirebaseDatabase dataBase;

    private DatabaseReference userRef;

    public UserRepository(Context context) {
        userDao = PetDatabase.getDatabase(context).getUserDao();
        FirebaseDatabase dataBase = FirebaseDatabase.getInstance(); // instancia firebase en database
        userRef = dataBase.getReference("user");
        loadInitialDatabase();
    }

    public void newUser(String name, String email, String password, String cellPhone){
        userDao.insert(
                new User(name, email, password, cellPhone)
        );
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


    private void loadInitialDatabase() {
        if(USE_DATABASE_LOCAL) {
            userDao.insert(
                    new User("Jose Pacheco", "jfpacheco11@gmail.com", "12345678" , "1234567890"),
                    new User("Usuario Prueba", "test@gmail.com", "87654321", "1234567890")
            );
        } else {
            userRef.setValue("test send data");
        }

    }

    public User getUserByEmail(String email) {
        if(USE_DATABASE_LOCAL) {
            return userDao.getUserByEmail(email);
        } else {
            //usar firebase
            // Read from the database
            userRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    String value = dataSnapshot.getValue(String.class);
                    Log.d(UserRepository.class.getSimpleName(), "Value is: " + value);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.w(UserRepository.class.getSimpleName(), "Failed to read value.", error.toException());
                }
            });
        }
        return null;
    }


    public  User getUserByEmailDataBaseOnline(String email){
        return userDao.getUserByEmail(email);
    }
}
