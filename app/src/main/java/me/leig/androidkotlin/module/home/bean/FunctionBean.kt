package me.leig.androidkotlin.module.home.bean

import me.leig.baselibrary.fragment.BaseFragment

/**
 *
 *
 * @author leig
 * @version 20180301
 *
 */

data class FunctionBean(
        val f: BaseFragment,
        val title: String = f.title)