package com.example.administrator.testkotlin.presenter

import com.example.administrator.testkotlin.contract.WeatherContract

/**
 * Created by Administrator on 2017/9/7.
 */
class WeatherPresenter(v: WeatherContract.View) : WeatherContract.Presenter {
    init {
        v.setPresenter(this)
    }

    override fun start() {
    }
}