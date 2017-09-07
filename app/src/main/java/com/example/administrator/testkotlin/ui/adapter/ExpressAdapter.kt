package com.example.administrator.testkotlin.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.administrator.testkotlin.R
import com.example.administrator.testkotlin.bean.Data

/**
 * Created by Administrator on 2017/9/6.
 */
class ExpressAdapter(val mContext: Context, var datas: MutableList<Data>) : BaseAdapter() {
    private val inflater: LayoutInflater = LayoutInflater.from(mContext)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var v: View? = convertView
        var holder: ViewHolder
        if (v == null) {
            v = inflater.inflate(R.layout.item_express, parent, false)
            holder = ViewHolder(v)
            v.tag = holder
        } else {
            holder = v.tag as ViewHolder
        }
        holder.tvTop.visibility = if (position == 0) View.GONE else View.VISIBLE
        holder.tvBottom.visibility = if (position == datas.size - 1) View.INVISIBLE else View.VISIBLE
        holder.tvDate.text = datas[position].time.split(" ")[0]
        holder.tvTime.text = datas[position].time.split(" ")[1].substring(0, 5)
        holder.tvContent.text = datas[position].context
        return v
    }

    override fun getItem(position: Int): Any = datas[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = datas.size

    class ViewHolder(v: View) {
        val tvDate = v.findViewById(R.id.item_exp_tv_date) as TextView
        val tvTime = v.findViewById(R.id.item_exp_tv_time) as TextView
        val tvTop = v.findViewById(R.id.item_exp_tv_top) as TextView
        val tvBottom = v.findViewById(R.id.item_exp_tv_bottom) as TextView
        val tvContent = v.findViewById(R.id.item_exp_tv_content) as TextView
    }
}