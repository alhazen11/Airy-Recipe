package com.apps.airyrecipe.abstraction.base

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.View

import androidx.appcompat.app.AppCompatActivity
import com.apps.airyrecipe.abstraction.utils.ext.toast
import com.apps.airyrecipe.abstraction.utils.view.KeyboardUtils


abstract class BaseActivity: AppCompatActivity(), BaseView {

    /**
     * lifecycle method
     * @method contentView(): @return resLayoutId
     * @method initView()depe
     */
    private lateinit var dialogView : View
    private lateinit var b : AlertDialog

    abstract fun contentView(): Int
    abstract fun initView()
    abstract fun initInjector()

    /**
     * (optional, use it if needed)
     */
    protected lateinit var savedInstanceState: Bundle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            this.savedInstanceState = savedInstanceState
        }
        setContentView(contentView())
        initInjector()
        initView()
    }

    override fun onMessage(message: String?) {
        toast(message)
    }

    override fun goTo(context: Class<*>) {
        startActivity(Intent(this, context))
    }

    override fun goToBack() {
        super.onBackPressed()
    }


    override fun onMessage(stringResId: Int) {
        onMessage(getString(stringResId))
    }

    /**
     * check internet connection
     */
    override fun isNetworkConnect(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.activeNetworkInfo != null && connectivityManager.activeNetworkInfo.isConnected
    }

    /**
     * hide keyboard layout
     */
    override fun hideKeyboard() {
        return KeyboardUtils().hide(this)
    }

}