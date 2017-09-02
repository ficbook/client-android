package org.unravel22.fbchat.ui.activities

import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.widget.Button
import android.widget.CheckBox
import android.widget.ProgressBar
import com.arellomobile.mvp.MvpAppCompatActivity
import org.unravel22.fbchat.ChatApplication
import org.unravel22.fbchat.R
import org.unravel22.fbchat.models.Account
import org.unravel22.fbchat.models.Credentials
import org.unravel22.fbchat.mvp.views.SignInView
import org.unravel22.fbchat.ui.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by admin on 01.09.17.
 */
class SignInActivity : MvpAppCompatActivity(), SignInView, Callback<Account> {

    val editLogin: TextInputEditText by view(R.id.edit_login)
    val editPassword: TextInputEditText by view(R.id.edit_password)
    val btnSignIn: Button by view(R.id.btn_signin)
    val progressBar: ProgressBar by view(R.id.progressBar)
    val checkBoxAgree: CheckBox by view(R.id.check_agree)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        setSupportActionBar(R.id.toolbar)
        btnSignIn.setOnClickListener { signIn() }
    }

    override fun signIn() {
        val call = (application as ChatApplication).restService.signIn(Credentials(
                editLogin.trimmedText,
                editPassword.trimmedText
        ))
        progressBar.show()
        call.enqueue(this)
    }

    override fun onResponse(call: Call<Account>?, response: Response<Account>?) {
        progressBar.gone()
        if (response?.isSuccessful == true) {
            val account = response.body()
            editPassword.shortSnackbar(account?.token ?: "null")
        } else {
            editPassword.error = response?.message() ?: "error"
        }
    }

    override fun onFailure(call: Call<Account>?, t: Throwable?) {
        progressBar.gone()
        btnSignIn.shortSnackbar(t?.message ?: "error")
    }
}