package me.leig.androidkotlin.module.home.ui

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.fragment_home.view.*
import me.leig.androidkotlin.R
import me.leig.androidkotlin.module.home.adapter.HomeAdapter
import me.leig.androidkotlin.module.home.bean.FunctionBean
import me.leig.androidkotlin.module.video.ui.VideoFragment
import me.leig.baselibrary.comm.ItemClickListener
import me.leig.baselibrary.fragment.BaseFragment

/**
 *
 *
 * @author leig
 * @version 20180301
 *
 */

class HomeFragment: BaseFragment("功能列表") {

    lateinit var functions: List<FunctionBean>

    override fun getClassTag(): String {
        return HomeFragment::class.java.name
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initData() {
        functions = listOf(
                FunctionBean(VideoFragment())
        )
    }

    override fun initView() {

        val homeAdapter = HomeAdapter(activity, functions)
        homeAdapter.setItemClickListener(object : ItemClickListener{
            override fun onItemClickListener(view: View, position: Int) {
                goToFragment(functions[position].f)
            }

            override fun onItemLongClickListener(view: View, position: Int) {

            }

        })
        mView.rv_functions.layoutManager = LinearLayoutManager(activity)
        mView.rv_functions.adapter = homeAdapter


    }

    override fun initEvent() {
        log("init Event")
    }

}