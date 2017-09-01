package org.unravel22.fbchat.ui.activities

import android.accounts.Account
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.widget.Button
import android.widget.FrameLayout
import com.arellomobile.mvp.MvpAppCompatActivity
import org.unravel22.fbchat.ChatApplication
import org.unravel22.fbchat.R
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
    val containerProgress: FrameLayout by view(R.id.container_progress)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        btnSignIn.setOnClickListener { signIn() }
    }

    override fun signIn() {
        val call = (application as ChatApplication).restService.signIn(
                editLogin.trimmedText,
                editPassword.trimmedText
        )
        containerProgress.show()
        call.enqueue(this)
    }

    override fun onResponse(call: Call<Account>?, response: Response<Account>?) {
        containerProgress.gone()
        if (response?.isSuccessful ?: false) {
            val account = response!!.body()

        } else {
            btnSignIn.shortSnackbar(response?.message() ?: "error")
        }
    }

    override fun onFailure(call: Call<Account>?, t: Throwable?) {
        containerProgress.gone()
        btnSignIn.shortSnackbar(t?.message ?: "error")
    }
}