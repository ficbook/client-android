package org.unravel22.fbchat.ui

import android.app.Activity
import android.support.annotation.IdRes
import android.view.View
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * Created by admin on 01.09.17.
 */
class ViewDelegate<T : View>(@IdRes private val viewId: Int) : ReadOnlyProperty<Activity, T> {

    var view: T? = null

    override fun getValue(thisRef: Activity, property: KProperty<*>): T {
        return view ?: let {
            view = thisRef.findViewById(viewId)
            view!!
        }
    }
}

fun<T : View> view(@IdRes id: Int): ViewDelegate<T> = ViewDelegate(id)