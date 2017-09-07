package com.example.administrator.testkotlin.constants

/**
 * Created by Administrator on 2017/9/6.
 */
public class Constants {
    companion object {
        val BASE_EXPRESS_URL = "http://www.kuaidi100.com/"
        val BASE_WEATHER_URL = "http://www.sojson.com/"
        val EXPRESS_TYPES = arrayOf("shentong", "ems", "shunfeng", "yuantong", "zhongtong", "yunda", "tiantian", "huitongkuaidi", "quanfengkuaidi", "debangwuliu", "zhaijisong")
        val EXPRESS_NAME_TYPES = arrayOf("申通", "EMS", "顺丰", "圆通", "中通", "韵达", "天天", "汇通", "全峰", "德邦", "宅急送")
        val CONNECT_TIME_OUT: Long = 5
    }
}