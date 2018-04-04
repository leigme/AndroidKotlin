package me.leig.androidkotlin.module.video.ui

import me.leig.androidkotlin.R
import me.leig.baselibrary.fragment.BaseFragment

/**
 *
 *
 * @author leig
 * @version 20180301
 *
 */

class VideoFragment: BaseFragment("视频播放") {

    override fun getClassTag(): String {
        return VideoFragment::class.java.name
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_video
    }

}