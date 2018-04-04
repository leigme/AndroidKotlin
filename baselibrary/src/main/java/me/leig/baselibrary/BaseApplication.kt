package me.leig.baselibrary

import android.app.Application
import android.util.Log

/**
 *
 *
 * @author i
 * @version 20171231
 * @date 2018/3/26
 *
 */

abstract class BaseApplication: Application() {

    abstract fun getClassTag(): String

    override fun onCreate() {
        super.onCreate()
        initApp()
        startApp()
    }

    abstract fun initApp()

    abstract fun startApp()

    fun log(msg: String) {
        Log.i(getClassTag(), msg)
    }
}