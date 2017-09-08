package com.example.administrator.testkotlin.presenter

import com.example.administrator.testkotlin.BaseSubscriber
import com.example.administrator.testkotlin.bean.WeatherInfo
import com.example.administrator.testkotlin.contract.WeatherContract
import com.example.administrator.testkotlin.network.HttpRequests
import rx.Subscriber

/**
 * Created by Administrator on 2017/9/7.
 */
class WeatherPresenter(var v: WeatherContract.View) : WeatherContract.Presenter {
    init {
        v.setPresenter(this)
    }

    override fun start() {
        HttpRequests.SingletonHolder.INSTANCE_WEATHER.requestWeather(object : BaseSubscriber<WeatherInfo>() {
            override fun onStart() {
                super.onStart()
                v.showDialog()
            }

            override fun onBaseNext(data: WeatherInfo) {
                v.hideDialog()
                val toList = data.data.forecast.toList() as MutableList<WeatherInfo.Data.Forecast>
                toList.add(data.data.yesterday)
                v.showWeather(toList)
                v.showCurrentWeather(data.data)
            }

            override fun onBaseError(e: Throwable?) {
                v.hideDialog()
            }
        })
    }
}