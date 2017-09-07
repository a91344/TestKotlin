package com.example.administrator.testkotlin.bean

/**
 * Created by Administrator on 2017/9/6.
 */

data class ExpressInfo(
        var message: String, // ok
        var nu: String, // 11111111111
        var ischeck: String, // 0
        var condition: String, // 00
        var com: String, // yuantong
        var status: String, // 200
        var state: String, // 0
        var data: List<Data>
) {
    data class Data(
            var time: String, // 2017-09-01 20:12:51
            var ftime: String, // 2017-09-01 20:12:51
            var context: String, // 快件已到达环东广场圆通快递云兰租车部妈妈驿站,如有疑问请联系18552351543
            var location: String
    )
}

