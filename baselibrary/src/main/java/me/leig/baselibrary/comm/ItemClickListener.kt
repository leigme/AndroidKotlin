package me.leig.baselibrary.comm

import android.view.View

/**
 *
 *
 * @author leig
 * @version 20180301
 *
 */

interface ItemClickListener {
    fun onItemClickListener(view: View, position: Int)
    fun onItemLongClickListener(view: View, position: Int)
}