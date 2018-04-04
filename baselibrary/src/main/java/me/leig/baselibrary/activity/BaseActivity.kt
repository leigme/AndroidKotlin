package me.leig.baselibrary.activity

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import me.leig.baselibrary.comm.BaseInterface
import me.leig.baselibrary.comm.Constant
import me.leig.baselibrary.fragment.BaseFragment

/**
 * 主入口程序基类
 *
 * @author leig
 * @version 20180301
 *
 */

abstract class BaseActivity: AppCompatActivity(), View.OnClickListener, BaseInterface {

    open val mHandler = Handler()

    private lateinit var toast: Toast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        toast = Toast.makeText(this, "", Toast.LENGTH_SHORT)
        initData()
        initView()
        initEvent()
    }

    override fun onClick(v: View?) {

    }

    override fun getFragmentId(): Int {
        return 0
    }
    fun log(msg: String) {
        Log.i(getClassTag(), msg)
    }

    fun toast(msg: String) {
        toast.setText(msg)
        toast.show()
    }

    fun goToFragment(f: BaseFragment, bundle: Bundle = Bundle()) {

        if (0 >= getFragmentId()) {
            log("主内容区域没有设置")
            return
        }

        try {
            val ft = fragmentManager.beginTransaction()
            bundle.putInt(Constant.FRAGMENTID, getFragmentId())
            f.arguments = bundle
            ft.replace(getFragmentId(), f)
            ft.addToBackStack(null)
            ft.commit()
        } catch (e: Exception) {
            log("捕获异常: " + e.message)
        }
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
}