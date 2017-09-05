package org.unravel22.fbchat.ui.activities

import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.widget.Button
import android.widget.CheckBox
import android.widget.ProgressBar
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import org.unravel22.fbchat.R
import org.unravel22.fbchat.models.Account
import org.unravel22.fbchat.models.Credentials
import org.unravel22.fbchat.mvp.presenters.SignInPresenter
import org.unravel22.fbchat.mvp.views.SignInView
import org.unravel22.fbchat.ui.*

/**
 * Created by admin on 01.09.17.
 */
class SignInActivity : MvpAppCompatActivity(), SignInView {

    @InjectPresenter
    lateinit var presenter: SignInPresenter

    private val editLogin: TextInputEditText by view(R.id.edit_login)
    private val editPassword: TextInputEditText by view(R.id.edit_password)
    private val btnSignIn: Button by view(R.id.btn_signin)
    private val progressBar: ProgressBar by view(R.id.progressBar)
    private val checkBoxAgree: CheckBox by view(R.id.check_agree)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        setSupportActionBar(R.id.toolbar)
        btnSignIn.setOnClickListener {
            presenter.signIn(Credentials(editLogin.trimmedText, editPassword.text.toString()))
        }
    }

    override fun setIsInProgress(progress: Boolean) {
        progressBar.visible = progress
    }

    override fun onSignedIn(account: Account) {
        editPassword.shortSnackbar(account.token)
    }

    override fun onSignInFailed(error: Throwable?, message: String?) {
        message?.let {
            editPassword.error = it
        } ?: btnSignIn.shortSnackbar(error?.message ?: "error")
    }
}