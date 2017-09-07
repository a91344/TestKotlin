package com.example.administrator.testkotlin.ui.activitys

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.administrator.testkotlin.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        initEvent()
    }

    private fun initData() {

    }

    private fun initEvent() {
        main_iv_exp.setOnClickListener({ startActivity(Intent(this@MainActivity, ExpressActivity::class.java)) })
    }

}
