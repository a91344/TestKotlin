package com.example.administrator.testkotlin.presenter

import android.os.Handler
import android.util.Log
import com.example.administrator.testkotlin.BaseSubscriber
import com.example.administrator.testkotlin.BaseSubscriber.Companion.handler
import com.example.administrator.testkotlin.bean.ExpressInfo
import com.example.administrator.testkotlin.contract.ExpressContract
import com.example.administrator.testkotlin.network.HttpRequests
import rx.Subscriber

/**
 * Created by Administrator on 2017/9/6.
 */
class ExpressPresenter(val expressView: ExpressContract.View) : ExpressContract.Presenter {
    override fun requestData(type: String, postin: String) {
        HttpRequests.SingletonHolder.INSTANCE_EXPRESS.requesetExpressInfo(object : BaseSubscriber<ExpressInfo>() {
            override fun onStart() {
                super.onStart()
                expressView.showDialog()
            }

            override fun onBaseNext(data: ExpressInfo) {
                expressView.hideDialog()
                if (data?.message?.equals("快递公司参数异常：单号不存在或者已经过期")!! || data?.message?.equals("参数错误")!!) {
                    expressView.setExpressContentStatus(data?.message)
                } else {
                    expressView.showExpress(data?.data?.toList() as MutableList<ExpressInfo.Data>)
                }
            }

            override fun onBaseError(e: Throwable?) {
                expressView.hideDialog()
                expressView.setExpressContentStatus("网络错误")
            }

        }, type, postin)
    }

    init {
        expressView.setPresenter(this)
    }

    override fun start() {

    }
}