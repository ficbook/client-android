package org.unravel22.fbchat.mvp.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import org.unravel22.fbchat.ChatApplication
import org.unravel22.fbchat.models.Account
import org.unravel22.fbchat.mvp.views.SignInView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by admin on 01.09.17.
 */
@InjectViewState
class SignInPresenter: MvpPresenter<SignInView>(), Callback<Account> {

    private var isInProgress = false
        set(value) {
            if (field != value) {
                viewState.setIsInProgress(value)
                field = value
            }
        }

    fun signIn() {
        val call = ChatApplication.graph.getRestService().signIn(viewState.getCredentials())
        isInProgress = true
        call.enqueue(this)
    }

    override fun onFailure(call: Call<Account>?, t: Throwable?) {
        isInProgress = false
        viewState.onSignInFailed(t, null)
    }

    override fun onResponse(call: Call<Account>?, response: Response<Account>?) {
        isInProgress = false
        if (response?.isSuccessful == true) {
            viewState.onSignedIn(response.body()!!)
        } else {
            viewState.onSignInFailed(null, response?.message())
        }
    }
}