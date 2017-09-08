package com.example.administrator.testkotlin.ui.activitys

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.administrator.testkotlin.MyApp
import com.example.administrator.testkotlin.R
import com.example.administrator.testkotlin.bean.ExpressInfo
import com.example.administrator.testkotlin.bean.WeatherInfo
import com.example.administrator.testkotlin.contract.WeatherContract
import com.example.administrator.testkotlin.presenter.WeatherPresenter
import com.example.administrator.testkotlin.ui.adapter.WeatherAdapter
import com.qmuiteam.qmui.widget.dialog.QMUIDialog
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog
import kotlinx.android.synthetic.main.aty_weather.*

/**
 * Created by Administrator on 2017/9/7.
 */
class WeatherActivity : AppCompatActivity(), WeatherContract.View {
    var datas: ArrayList<WeatherInfo.Data.Forecast> = ArrayList()
    var adapter: WeatherAdapter? = null
    var dialog: QMUITipDialog? = null
    var pre: WeatherContract.Presenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.aty_weather)
        initData()
        initEvent()
    }

    private fun initData() {
        dialog = QMUITipDialog.Builder(this@WeatherActivity).setTipWord("正在加载").setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING).create()

        adapter = WeatherAdapter(this@WeatherActivity, datas)
        wea_lv_datas.adapter = adapter

        WeatherPresenter(this)
        pre?.start()

    }

    private fun initEvent() {

    }

    override fun setPresenter(presenter: WeatherContract.Presenter) {
        pre = presenter
    }

    override fun showWeather(datas: MutableList<WeatherInfo.Data.Forecast>) {
        this.datas.clear()
        this.datas.removeAll(this.datas)
        this.datas.addAll(datas)
        adapter?.notifyDataSetChanged()
    }

    override fun showCurrentWeather(data: WeatherInfo.Data) {
        wea_tv_city.text = MyApp.city
        wea_tv_temperature_or_quality.text = "温度:${data.wendu}\n 质量:${data.quality}"
        wea_tv_pm.text = "PM2.5:${data.pm25}\n PM1.0:${data.pm10}"
        wea_tv_humidity.text = "湿度:${data.shidu}"
        wea_tv_notice.text = "提示:${data.ganmao}"
    }

    override fun showDialog() {
        dialog?.show()
        wea_ll.visibility = View.GONE
    }

    override fun hideDialog() {
        dialog?.dismiss()
        dialog?.hide()
        wea_ll.visibility = View.VISIBLE
    }
}