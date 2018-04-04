package me.leig.baselibrary.comm

/**
 *
 *
 * @author leig
 * @version 20171231
 * @date 2018/3/26
 *
 */

interface BaseInterface {

    fun getClassTag(): String

    fun getLayoutId(): Int

    fun getFragmentId(): Int

    fun initData()

    fun initView()

    fun initEvent()
}