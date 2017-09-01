package org.unravel22.fbchat.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.unravel22.fbchat.R
import org.unravel22.fbchat.ui.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(SignInActivity::class.java)
    }
}
