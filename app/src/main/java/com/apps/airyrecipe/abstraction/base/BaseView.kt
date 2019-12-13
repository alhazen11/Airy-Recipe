package com.apps.airyrecipe.abstraction.base

import android.content.Context
import android.view.View

interface BaseView {
    fun onMessage(message: String?)
    fun onMessage(stringResId: Int)
    fun goTo(context: Class<*>)
    fun isNetworkConnect(context: Context): Boolean
    fun hideKeyboard()
    fun goToBack()
 }