package org.unravel22.fbchat.mvp.views

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import org.unravel22.fbchat.models.Account

/**
 * Created by admin on 01.09.17.
 */
@StateStrategyType(AddToEndSingleStrategy::class)
interface SignInView : MvpView {

    fun setIsInProgress(progress: Boolean)

    fun onSignedIn(account: Account)

    fun onSignInFailed(error: Throwable?, message: String?)
}