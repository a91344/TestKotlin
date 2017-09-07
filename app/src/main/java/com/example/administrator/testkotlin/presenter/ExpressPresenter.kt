package com.example.administrator.testkotlin.presenter

import android.os.Handler
import android.util.Log
import com.example.administrator.testkotlin.bean.ExpressInfo
import com.example.administrator.testkotlin.contract.ExpressContract
import com.example.administrator.testkotlin.network.HttpRequests
import rx.Subscriber

/**
 * Created by Administrator on 2017/9/6.
 */
class ExpressPresenter(val expressView: ExpressContract.View) : ExpressContract.Presenter {
    var time: Long = 0
    var handler: Handler = Handler()
    override fun requestData(type: String, postin: String) {
        HttpRequests.SingletonHolder.instanceMusic.requesetExpressInfo(object : Subscriber<ExpressInfo>() {
            override fun onStart() {
                super.onStart()
                expressView.showDialog()
            }

            override fun onNext(t: ExpressInfo?) {
                handler.postDelayed({
                    expressView.hideDialog()
                    time = 0
                    Log.i("AAA", t.toString())
                    if (t?.message?.equals("快递公司参数异常：单号不存在或者已经过期")!! || t?.message?.equals("参数错误")!!) {
                        expressView.setExpressContentStatus(t?.message)
                    } else {
                        expressView.showExpress(t?.data?.toList() as MutableList<ExpressInfo.Data>)
                    }
                }, time)
            }

            override fun onCompleted() {

            }

            override fun onError(e: Throwable?) {
                handler.postDelayed({
                    expressView.hideDialog()
                    time = 600
                    expressView.setExpressContentStatus("网络错误")
                }, time)
            }
        }, type, postin)
    }

    init {
        expressView.setPresenter(this)
    }

    override fun start() {

    }
}