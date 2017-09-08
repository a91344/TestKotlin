package com.example.administrator.testkotlin

import android.os.Handler
import rx.Subscriber

/**
 * Created by Administrator on 2017/9/8.
 */
abstract class BaseSubscriber<T> : Subscriber<T>() {
    var time: Long = 0

    companion object {
        var handler: Handler = Handler()
    }

    override fun onStart() {

    }

    override fun onError(e: Throwable?) {
        handler.postDelayed({ onBaseError(e) }, time)
    }

    override fun onNext(data: T) {
        handler.postDelayed({ onBaseNext(data) }, time)
    }

    override fun onCompleted() {
    }

    abstract fun onBaseNext(data: T)
    abstract fun onBaseError(e: Throwable?)
}