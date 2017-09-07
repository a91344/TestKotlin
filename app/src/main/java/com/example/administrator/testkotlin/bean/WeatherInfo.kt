package com.example.administrator.testkotlin.bean

/**
 * Created by Administrator on 2017/9/7.
 */


data class WeatherInfo(
        var message: String, // Success !
        var status: Int, // 200
        var city: String, // 北京
        var count: Int, // 1
        var data: Data
) {
    data class Data(
            var shidu: String, // 52%
            var pm25: Double, // 17.0
            var pm10: Double, // 54.0
            var quality: String, // 良
            var wendu: String, // 22
            var ganmao: String, // 极少数敏感人群应减少户外活动
            var yesterday: Yesterday,
            var forecast: List<Forecast>
    )

    data class Forecast(
            var date: String, // 07日星期四
            var sunrise: String, // 05:46
            var high: String, // 高温 31.0℃
            var low: String, // 低温 19.0℃
            var sunset: String, // 18:38
            var aqi: Double, // 39.0
            var fx: String, // 西南风
            var fl: String, // <3级
            var type: String, // 晴
            var notice: String// lovely sunshine，尽情享受阳光的温暖吧
    )

    data class Yesterday(
            var date: String, // 06日星期三
            var sunrise: String, // 05:45
            var high: String, // 高温 31.0℃
            var low: String, // 低温 18.0℃
            var sunset: String, // 18:39
            var aqi: Double, // 38.0
            var fx: String, // 北风
            var fl: String, // <3级
            var type: String, // 晴
            var notice: String// lovely sunshine，尽情享受阳光的温暖吧
    )
}

