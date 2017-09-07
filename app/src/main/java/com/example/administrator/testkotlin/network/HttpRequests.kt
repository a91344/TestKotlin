package com.example.administrator.testkotlin.network

import com.example.administrator.testkotlin.bean.ExpressInfo
import com.example.administrator.testkotlin.constants.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Scheduler
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * Created by Administrator on 2017/9/6.
 */
class HttpRequests private constructor(url: String) {
    private val requestApi: RequestsApi

    object SingletonHolder {
        val instanceMusic = HttpRequests(Constants.BASE_EXPRESS_URL)
    }

    init {
        val okHttpClient = OkHttpClient.Builder().connectTimeout(Constants.CONNECT_TIME_OUT, TimeUnit.SECONDS).build()
        val build = Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build()
        requestApi = build.create(RequestsApi::class.java)
    }

    public fun requesetExpressInfo(subscriber: Subscriber<ExpressInfo>,type:String,postid:String) {
        requestApi.requestExpressInfo(type,postid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber)
    }
}