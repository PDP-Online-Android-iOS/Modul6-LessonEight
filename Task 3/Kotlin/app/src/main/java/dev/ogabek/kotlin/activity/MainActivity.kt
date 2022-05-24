package dev.ogabek.kotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import dev.ogabek.kotlin.R
import dev.ogabek.kotlin.manager.AuthManager

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ImageView>(R.id.iv_logout).setOnClickListener {
            AuthManager.signOut()
            callSignInActivity()
        }

    }
}