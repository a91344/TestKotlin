package com.example.administrator.testkotlin

/**
 * Created by Administrator on 2017/9/6.
 */
interface BaseView<T> {
    abstract fun setPresenter(presenter: T)
}