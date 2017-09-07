package com.example.administrator.testkotlin.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.administrator.testkotlin.R
import com.example.administrator.testkotlin.bean.WeatherInfo

/**
 * Created by Administrator on 2017/9/7.
 */
class WeatherAdapter(val mContext: Context, val datas: MutableList<WeatherInfo.Forecast>) : BaseAdapter() {
    val inflater: LayoutInflater = LayoutInflater.from(mContext)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var v: View? = convertView
        var holder: ViewHolder
        if (v == null) {
            v = inflater.inflate(R.layout.item_weather, parent, false)
            holder = ViewHolder(v)
            v.tag = holder
        } else {
            holder = v.tag as ViewHolder
        }
        var isCurrent = position == 2
        val forecast = datas[position]
        holder.itemWeaIv.setBackgroundResource(when (forecast.type) {
            "晴" -> if (isCurrent) R.mipmap.current_fine else R.mipmap.fine
            "阵雨" -> if (isCurrent) R.mipmap.current_rainy else R.mipmap.rainy
            "雷阵雨" -> if (isCurrent) R.mipmap.current_thunder else R.mipmap.thunder
            "多云" -> if (isCurrent) R.mipmap.current_overcast else R.mipmap.overcast
            "阴" -> if (isCurrent) R.mipmap.current_cloudy else R.mipmap.cloudy
            else -> R.mipmap.fine
        })
        holder.itemWeaTvType.text = forecast.type
        holder.itemWeaTvDate.text = forecast.date
        holder.itemWeaTvAqi.text = "空气质量指数:${forecast.aqi}"
        holder.itemWeaTvTemperature.text="${forecast.low} ${forecast.high}"
        holder.itemWeaTvWarn.text="注意\n${forecast.notice}"
        holder.itemWeaTvWindDirection.text="风向:${forecast.fx} 风级:${forecast.fl}"
        return v
    }

    override fun getItem(position: Int): Any = datas[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = datas.size
    class ViewHolder(v: View) {
        val itemWeaIv = v.findViewById(R.id.item_wea_iv) as ImageView
        val itemWeaTvType = v.findViewById(R.id.item_wea_tv_type) as TextView
        val itemWeaTvDate = v.findViewById(R.id.item_wea_tv_date) as TextView
        val itemWeaTvWindDirection = v.findViewById(R.id.item_wea_tv_wind_direction) as TextView
        val itemWeaTvAqi = v.findViewById(R.id.item_wea_tv_aqi) as TextView
        val itemWeaTvTemperature = v.findViewById(R.id.item_wea_tv_temperature) as TextView
        val itemWeaTvWarn = v.findViewById(R.id.item_wea_tv_warn) as TextView
    }
}