package com.example.administrator.testkotlin.ui.activitys

import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.administrator.testkotlin.R
import com.example.administrator.testkotlin.bean.ExpressInfo
import com.example.administrator.testkotlin.constants.Constants
import com.example.administrator.testkotlin.contract.ExpressContract
import com.example.administrator.testkotlin.presenter.ExpressPresenter
import com.example.administrator.testkotlin.ui.adapter.ExpressAdapter
import com.qmuiteam.qmui.widget.dialog.QMUIDialog
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog
import kotlinx.android.synthetic.main.aty_express.*
import java.util.*


/**
 * Created by Administrator on 2017/9/6.
 */
class ExpressActivity : AppCompatActivity(), ExpressContract.View {
    var pre: ExpressContract.Presenter? = null
    var datas: ArrayList<ExpressInfo.Data> = ArrayList()
    var expressAdapter: ExpressAdapter? = null
    var loadingDialog: QMUITipDialog? = null
    var type: String = ""
    var dialog: QMUIDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.aty_express)
        initData()
        initEvent()
    }

    private fun initData() {
        ExpressPresenter(this)
        expressAdapter = ExpressAdapter(this@ExpressActivity, datas)
        exp_lv_data.adapter = expressAdapter
        exp_lv_data.emptyView = exp_ev
        setExpressContentStatus("什么都没有")

        loadingDialog = QMUITipDialog.Builder(this@ExpressActivity).setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING).setTipWord("正在加载").create()
        val checkableDialogBuilder = QMUIDialog.CheckableDialogBuilder(this@ExpressActivity)
        dialog = checkableDialogBuilder.addItems(Constants.EXPRESS_NAME_TYPES) { _, i ->
            type = Constants.EXPRESS_TYPES[i]
            exp_tv_type.text = Constants.EXPRESS_NAME_TYPES[i]
            dialog?.dismiss()
            dialog?.hide()
        }.create()
    }

    private fun initEvent() {
        exp_bt_search.setOnClickListener { pre?.requestData(type, exp_et_search.text.toString().trim()) }
        exp_tv_type.setOnClickListener { dialog?.show() }
    }

    override fun setPresenter(presenter: ExpressContract.Presenter) {
        pre = presenter
    }

    override fun showExpress(datas: MutableList<ExpressInfo.Data>) {
        this.datas.addAll(datas)
        Collections.reverse(this.datas)
        expressAdapter?.notifyDataSetChanged()

    }

    override fun setExpressContentStatus(msg: String) {
        exp_ev.setDetailText(msg)
    }

    override fun showDialog() {
        datas.clear()
        datas.removeAll(datas)
        expressAdapter?.notifyDataSetChanged()
        loadingDialog?.show()
        exp_ev.visibility = View.GONE
    }

    override fun hideDialog() {
        loadingDialog?.dismiss()
        loadingDialog?.hide()
        expressAdapter?.notifyDataSetChanged()
    }
}