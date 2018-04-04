package me.leig.androidkotlin.module.home.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import me.leig.androidkotlin.R
import me.leig.androidkotlin.module.home.bean.FunctionBean

/**
 *
 *
 * @author leig
 * @version 20180301
 *
 */
class HomeAdapter constructor(private val context: Context, private val datas: List<FunctionBean>): RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_function, parent, false)
        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.title.text = datas[position].title
    }


    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var title:TextView = itemView.findViewById(R.id.tv_title) as TextView

    }
}