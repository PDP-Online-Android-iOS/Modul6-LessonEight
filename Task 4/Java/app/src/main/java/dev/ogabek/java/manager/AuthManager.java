package dev.ogabek.java.manager;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AuthManager {

    private static FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private static FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

    public static boolean isSignedIn() {
        return firebaseUser != null;
    }

    public static void signIn(String email, String password, AuthHandler handler) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                handler.onSuccess();
            } else {
                handler.onError(task.getException());
            }
        });
    }

    public static void signUp(String email, String password, AuthHandler handler) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                handler.onSuccess();
            } else {
                handler.onError(task.getException());
            }
        });
    }

    public static void signOut() {
        firebaseAuth.signOut();
    }

}
