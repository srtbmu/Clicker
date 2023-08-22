package com.example.clicker.presenter

import com.example.clicker.MainActivity
import com.example.clicker.model.CounterModel
import com.example.clicker.view.CounterView

class Presenter {

    private var model = CounterModel()
    private lateinit var view: CounterView

    fun incrementCount() {
        model.increment()
        view.updateText(model.count.toString())
    }

    fun attachVIew(view: MainActivity) {
        this.view = view
    }


}