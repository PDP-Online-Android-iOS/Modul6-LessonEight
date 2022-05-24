package dev.ogabek.java.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import dev.ogabek.java.R;
import dev.ogabek.java.manager.AuthHandler;
import dev.ogabek.java.manager.AuthManager;

public class SignInActivity extends BaseActivity {

    protected static final String TAG = SignInActivity.class.toString();
    EditText et_email, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        initViews();

    }

    private void initViews() {
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        Button b_signin = findViewById(R.id.b_signin);
        b_signin.setOnClickListener(view -> {
            firebaseSignIn(et_email.getText().toString(), et_password.getText().toString());
        });
        TextView tv_signup = findViewById(R.id.tv_signup);
        tv_signup.setOnClickListener(view -> callSignUpActivity());
    }

    private void firebaseSignIn(String email, String password) {
        showLoading(this);
        AuthManager.signIn(email, password, new AuthHandler() {
            @Override
            public void onSuccess() {
                dismissLoading();
                Toast.makeText(context, "Sign In Successfully", Toast.LENGTH_SHORT).show();
                callMainActivity();
            }

            @Override
            public void onError(Exception exception) {
                dismissLoading();
                Toast.makeText(context, "Sign In Failed" + exception.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}