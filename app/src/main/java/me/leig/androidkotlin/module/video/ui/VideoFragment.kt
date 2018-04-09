package me.leig.androidkotlin.module.video.ui

import android.content.Intent
import android.widget.Button
import android.widget.VideoView
import me.leig.androidkotlin.R
import me.leig.baselibrary.fragment.BaseFragment
import me.leig.videolibrary.VideoPlayer

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

    override fun initEvent() {
        val btnView = mView.findViewById<Button>(R.id.btn_go_video)
        btnView.setOnClickListener({
            val intent = Intent(activity, VideoPlayer::class.java)
            activity.startActivity(intent)
        })
    }

}