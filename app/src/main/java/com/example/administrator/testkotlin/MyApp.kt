package com.example.administrator.testkotlin

import android.app.Application
import android.util.Log
import com.example.administrator.testkotlin.bean.LocationInfo
import com.example.administrator.testkotlin.network.HttpRequests
import rx.Subscriber

/**
 * Created by Administrator on 2017/9/8.
 */
class MyApp : Application() {
    companion object {
        var city: String = "北京"
    }

    override fun onCreate() {
        super.onCreate()
        requestLocation()
    }

    public fun requestLocation() {
        HttpRequests.SingletonHolder.INSTANCE_LOCATION.requestLocationInfo(object : Subscriber<LocationInfo>() {
            override fun onError(e: Throwable?) {
                Log.i("AAA",e.toString())
            }

            override fun onCompleted() {
            }

            override fun onNext(t: LocationInfo?) {
                city = t?.city!!
            }
        })
    }
}