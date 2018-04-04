package me.leig.androidkotlin

import kotlinx.android.synthetic.main.activity_main.*
import me.leig.androidkotlin.module.home.ui.HomeFragment
import me.leig.baselibrary.activity.BaseActivity

class MainActivity : BaseActivity() {

    override fun getFragmentId(): Int {
        return R.id.fl_main
    }

    lateinit var title: String

    override fun getClassTag(): String {
        return MainActivity::class.java.name
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
        title = stringFromJNI()
    }

    override fun initView() {
        sample_text.text = title
        goToFragment(HomeFragment())
    }

    override fun initEvent() {
        log("点击事件...")
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    private external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
