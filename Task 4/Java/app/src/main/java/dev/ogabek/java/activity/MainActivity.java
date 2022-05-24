package dev.ogabek.java.activity;

import android.os.Bundle;
import dev.ogabek.java.R;
import dev.ogabek.java.manager.AuthManager;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.iv_logout).setOnClickListener(view -> {
            AuthManager.signOut();
            callSignInActivity();
        });

    }
}