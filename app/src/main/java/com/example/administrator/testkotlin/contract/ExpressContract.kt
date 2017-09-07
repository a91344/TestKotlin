package com.example.administrator.testkotlin.contract

import com.example.administrator.testkotlin.BasePresenter
import com.example.administrator.testkotlin.BaseView
import com.example.administrator.testkotlin.bean.ExpressInfo

/**
 * Created by Administrator on 2017/9/6.
 */
class ExpressContract {
    interface View : BaseView<Presenter> {
        abstract fun showExpress(datas: MutableList<ExpressInfo.Data>)
        abstract fun setExpressContentStatus(msg: String)
        abstract fun showDialog()
        abstract fun hideDialog()
    }

    interface Presenter : BasePresenter{
        abstract fun requestData(type: String, postin: String)
    }
}