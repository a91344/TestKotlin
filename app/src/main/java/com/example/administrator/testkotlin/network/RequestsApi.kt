package com.example.administrator.testkotlin.network

import com.example.administrator.testkotlin.bean.ExpressInfo
import com.example.administrator.testkotlin.bean.LocationInfo
import com.example.administrator.testkotlin.bean.WeatherInfo
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * Created by Administrator on 2017/9/6.
 */
interface RequestsApi {
    @GET("query")
    abstract fun requestExpressInfo(@Query("type") type: String, @Query("postid") postid: String): Observable<ExpressInfo>

    @GET("json")
    abstract fun requestLocationInfo(@Query("lang") lang: String): Observable<LocationInfo>

    @GET("open/api/weather/json.shtml")
    abstract fun requestWeatherInfo(@Query("city") city: String): Observable<WeatherInfo>
}