package com.example.administrator.testkotlin.network

import com.example.administrator.testkotlin.bean.ExpressInfo
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * Created by Administrator on 2017/9/6.
 */
 interface RequestsApi {
    @GET("query")
    abstract fun requestExpressInfo(@Query("type") type: String, @Query("postid") postid: String): Observable<ExpressInfo>
}