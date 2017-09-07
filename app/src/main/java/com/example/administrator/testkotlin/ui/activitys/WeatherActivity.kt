package com.example.administrator.testkotlin.ui.activitys

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.administrator.testkotlin.R
import com.example.administrator.testkotlin.bean.ExpressInfo
import com.example.administrator.testkotlin.bean.WeatherInfo
import com.example.administrator.testkotlin.contract.WeatherContract

/**
 * Created by Administrator on 2017/9/7.
 */
class WeatherActivity : AppCompatActivity(), WeatherContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.aty_weather)
        initData()
        initEvent()
    }

    private fun initData() {

    }

    private fun initEvent() {

    }

    override fun setPresenter(presenter: WeatherContract.Presenter) {
    }

    override fun showWeather(datas: MutableList<WeatherInfo.Forecast>) {
    }

    override fun showDialog() {
    }

    override fun hideDialog() {
    }
}