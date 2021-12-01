package com.faroti.petshotel.model.repository;

import android.content.Context;
import android.content.Intent;

import com.faroti.petshotel.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class GmailAuthRepository {
    private static GmailAuthRepository instance;

    public static GmailAuthRepository getInstance(Context context) {
        if (instance == null) {
            instance = new GmailAuthRepository(context);
        }
        return instance;
    }

    private Context context;
    private GoogleSignInClient googleSignInClient;
    private GoogleSignInAccount account;

    private GmailAuthRepository(Context context) {
        this.context = context;
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(context.getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        googleSignInClient = GoogleSignIn.getClient(context, gso);

    }

    public boolean isAuthenticated() {
        return getAccount() != null;
    }

    public GoogleSignInAccount getAccount() {
        if (account == null) {
            account = GoogleSignIn.getLastSignedInAccount(context);
        }
        return account;
    }

    public Intent getSignInIntent() {
        return googleSignInClient.getSignInIntent();
    }

    public void setLoginData(Intent data) {
        Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
        try {
            account = task.getResult(ApiException.class);
            //Signin successfully
            updateUI(account);
        } catch (ApiException e) {
            updateUI(null);
        }
    }


    public interface GmailAuthCallback{
        void onSuccess();
        void onFail();
    }
}
