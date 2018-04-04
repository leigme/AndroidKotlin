package me.leig.baselibrary.fragment

import android.app.Fragment
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import me.leig.baselibrary.comm.BaseInterface
import me.leig.baselibrary.comm.Constant

/**
 * 主要视图基类
 *
 * @author i
 * @version 20171231
 * @date 2018/3/27
 *
 */

abstract class BaseFragment constructor(val title: String): Fragment(), View.OnClickListener, View.OnTouchListener, BaseInterface {

    open val mHandler = Handler()

    lateinit var mView: View

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        return true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mView = inflater.inflate(getLayoutId(), container, false)

        mView.setBackgroundColor(Color.WHITE)
        mView.setOnTouchListener(this)

        initData()
        initView()
        initEvent()

        return mView
    }

    override fun initData() {
        log("init data")
    }

    override fun initView() {
        log("init view")
    }

    override fun initEvent() {
        log("init Event")
    }

    fun goToFragment(f: BaseFragment, bundle: Bundle = Bundle()) {
        val ft = activity.fragmentManager.beginTransaction()
        bundle.putInt(Constant.FRAGMENTID, getFragmentId())
        f.arguments = bundle
        ft.replace(getFragmentId(), f)
        ft.addToBackStack(null)
        ft.commit()
    }

    override fun onClick(v: View?) {

    }

    override fun getFragmentId(): Int {
        return arguments.getInt(Constant.FRAGMENTID)
    }

    fun log(msg: String) {
        Log.i(getClassTag(), msg)
    }

}