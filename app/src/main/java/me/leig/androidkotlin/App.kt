package me.leig.androidkotlin

import me.leig.baselibrary.BaseApplication

/**
 *
 *
 * @author leig
 * @version 20180301
 *
 */

class App: BaseApplication() {

    override fun getClassTag(): String {
        return App::class.java.name
    }

    override fun initApp() {
        log("init project")
    }

    override fun startApp() {
        log("start app")
    }

}