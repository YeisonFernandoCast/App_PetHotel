package com.faroti.petshotel.model.repository;

import android.content.Context;

import com.faroti.petshotel.model.database.PetDatabase;
import com.faroti.petshotel.model.database.dao.UserDao;
import com.faroti.petshotel.model.database.entities.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static UserRepository instance;

    public  static UserRepository getInstance(Context context){
        if (instance == null){
            instance = new UserRepository(context);
        }
        return instance;
    }

    private final static Boolean USE_DATABASE_LOCAL = Boolean.FALSE;
    private UserDao userDao ;
    private DatabaseReference userRef;
    private DatabaseReference GardenRef;
    private FirebaseDatabase dataBase;

    private UserRepository(Context context) {
        userDao = PetDatabase.getDatabase(context).getUserDao();
        dataBase = FirebaseDatabase.getInstance(); // instancia firebase en database
        GardenRef = dataBase.getReference("Garden");
        userRef = dataBase.getReference("Users");
        //loadInitialDatabase();
    }

    public void newUser(String name, String email, String password, String cellPhone){
        User user = new User(name, email, password, cellPhone);
        String userName = email.replace('@','_').replace('.','_');

        if(USE_DATABASE_LOCAL) {
            userDao.insert(user);
                    //new User(name, email, password, cellPhone));
        } else {
         /*
            userRef.child(userName).child("name").setValue(name);
            userRef.child(userName).child("password").setValue(password);
            userRef.child(userName).child("cellPhone").setValue(cellPhone);
            userRef.child(userName).child("email").setValue(email);
          */

            userRef.child(userName).setValue(user);
            //userRef.child(userName).setValue(new User(name,email,password,cellPhone));
        }
    }

    private void loadInitialDatabase() {
        if(USE_DATABASE_LOCAL) {
            userDao.insert(
                    //new User("Usuario Prueba", "test@gmail.com", "87654321", "1234567890")

            );
        } else {
            String userName = "testmanual@gmail.com".replace('@','_').replace('.','_');

            userRef.child(userName).child("name").setValue("manual test");
            userRef.child(userName).child("password").setValue("12345678");
            userRef.child(userName).child("cellPhone").setValue("1234567890");
            userRef.child(userName).child("email").setValue("testmanual@gmail.com");
            userRef.setValue(userName);
        }

    }

    public void getUserByEmail(String email, UserCallBack<User> callback) {
        if(USE_DATABASE_LOCAL) {
            callback.onSuccess(userDao.getUserByEmail(email));
        } else {
            //usar firebase
            String userName = email.replace('@','_').replace('.','_');
            userRef.child(userName).get()
                    .addOnCompleteListener(task -> {
                        if(task.isSuccessful()){
                            User value = task.getResult().getValue(User.class);
                            //Log.d(UserRepository.class.getSimpleName(), "Value is: " + value);
                            callback.onSuccess(value);
                        } else {
                            callback.onFail();
                        }
                    });

                    /*
                    .addValueEventListener(new ValueEventListener() { // este metodo es para actualizar cada cambio que se haga en la
                                                                        //base de datos sobre la tabla users que le da userRef
            @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    User value = dataSnapshot.getValue(User.class);
                    callback.onSuccess(value);
                    Log.d(UserRepository.class.getSimpleName(), "Value is: " + value);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    callback.onFail();
                    Log.w(UserRepository.class.getSimpleName(), "Failed to read value.", error.toException());
                }
            });
            */
        }
    }

    public void getAll(UserCallBack<List<User>> callBack){
        userRef.getParent().get().addOnCompleteListener(task ->{
            if (task.isSuccessful()){
               DataSnapshot dataSnapshot = task.getResult();
               if(dataSnapshot.hasChildren()){
                   List<User> users = new ArrayList<>();
                   for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                       //snapshot.child("name").getValue(String.class);
                       User user = snapshot.getValue(User.class);
                       users.add(user);
                   }

                   callBack.onSuccess(users);
               } else {
                   callBack.onSuccess(new ArrayList<>());
               }
            } else {
                callBack.onFail();
            }
        });
    }

    public interface UserCallBack <T> {
        void onSuccess(T data);
        void onFail();
    }

}
