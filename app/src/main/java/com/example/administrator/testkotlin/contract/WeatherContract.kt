package com.example.administrator.testkotlin.contract

import com.example.administrator.testkotlin.BasePresenter
import com.example.administrator.testkotlin.BaseView
import com.example.administrator.testkotlin.bean.WeatherInfo

/**
 * Created by Administrator on 2017/9/7.
 */
interface WeatherContract {
    interface View : BaseView<Presenter> {
        abstract fun showWeather(datas: MutableList<WeatherInfo.Data.Forecast>)
        abstract fun showCurrentWeather(data: WeatherInfo.Data)
        abstract fun showDialog()
        abstract fun hideDialog()
    }

    interface Presenter : BasePresenter {}
}