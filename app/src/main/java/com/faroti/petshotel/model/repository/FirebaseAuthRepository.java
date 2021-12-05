package com.faroti.petshotel.model.repository;

import android.content.Context;

import com.faroti.petshotel.model.database.entities.User;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class FirebaseAuthRepository {

    private static FirebaseAuthRepository instance;

    public static FirebaseAuthRepository getInstance(Context context) {
        if(instance ==null){
            instance = new FirebaseAuthRepository(context);
        }
        return instance;
    }

    private FirebaseAuth AUTH;
    public FirebaseUser currentUser;
    private UserRepository userRepository;

    private FirebaseAuthRepository(Context context) {
        this.userRepository = UserRepository.getInstance(context);
        this.AUTH = FirebaseAuth.getInstance();
    }


    public boolean isAuthenticated() {
        return getCurrentUser() != null;
    }


    public FirebaseUser getCurrentUser() {
        if (currentUser == null) {
            currentUser = AUTH.getCurrentUser();
        }
        return currentUser;
    }

    public void newUser(User user, FirebaseAuthCallback callback) {
        AUTH.createUserWithEmailAndPassword(user.getEmail(), user.getPassword())
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        currentUser = AUTH.getCurrentUser();
                        //userRepository.save(user);
                        userRepository.newUser(user.getName(),
                                user.getEmail(),
                                user.getCellPhone(),
                                user.getPassword());
                        callback.onSuccess();
                    } else {
                        callback.onFail();

                    }
                });
    }

    public void login(String email, String password, FirebaseAuthCallback callback) {
        AUTH.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        currentUser = AUTH.getCurrentUser();
                        callback.onSuccess();
                    } else {
                        callback.onFail();
                    }
                });
    }

    public void logout(FirebaseAuthCallback callback) {
        if (currentUser != null) {
            AUTH.signOut();
            currentUser = null;
            callback.onSuccess();
        }else {
            callback.onFail();
        }
    }


    public interface FirebaseAuthCallback {
        void onSuccess();

        void onFail();
    }


    public void gmailAuth(String idToken, GmailAuthRepository.GmailAuthCallback callback) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        AUTH.signInWithCredential(credential)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        currentUser = AUTH.getCurrentUser();
                        callback.onSuccess();
                    } else {
                        callback.onFail();
                    }
                });
    }

}
