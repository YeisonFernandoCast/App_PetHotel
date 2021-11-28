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

import java.util.ArrayList;
import java.util.List;


public class UserRepository {
    private final static Boolean USE_DATABASE_LOCAL = Boolean.FALSE;
    private UserDao userDao ;
    private DatabaseReference userRef;
    //public FirebaseDatabase dataBase;

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

    private void loadInitialDatabase() {
        if(USE_DATABASE_LOCAL) {
            userDao.insert(
                    //new User("Usuario Prueba", "test@gmail.com", "87654321", "1234567890")

            );
        } else {
            //userRef.setValue("Bienvenido a Pet Hotel");
            String username = ("Yeison Castaño");
            userRef.child(username).setValue(new User("yeison", "yei@gmail.com", "asdfghjk", "3014225187"));
        }

    }

    public void getUserByEmail(String email, UserCallback<User> callback) {
        if (USE_DATABASE_LOCAL){
            callback.onSuccess(userDao.getUserByEmail(email)); //BD local
        } else {

            // leer de Bd de FireBase  hacer consulta
            String username = email.replace("@","_").replace(".", "_");
            userRef.child(username).get()
                    .addOnCompleteListener(task ->  {
                        if (task.isSuccessful()){
                            User value = task.getResult().getValue(User.class);
                            callback.onSuccess(value);
                        } else{
                            callback.onFailure();
                        }
                    });
        }
    }
    public void getAll(UserCallback<List<User>> callback){
        userRef.get().addOnCompleteListener(task -> {
            if(task.isSuccessful()){
                DataSnapshot dataSnapshot =task.getResult();
                if(dataSnapshot.hasChildren()){
                    List<User> users = new ArrayList<>();
                    for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                        User user = snapshot.getValue(User.class);
                        Log.d(UserRepository.class.getSimpleName(),user.toString());
                        users.add(user);
                    }
                    callback.onSuccess(users);
                }

            }else{
                callback.onFailure();
            }
        });

    }

    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    public interface UserCallback<T>{
        void onSuccess(T data);

        void onFailure();
    }

    public  User getUserByEmailDataBase(String email){
        return userDao.getUserByEmail(email);
    }
}
