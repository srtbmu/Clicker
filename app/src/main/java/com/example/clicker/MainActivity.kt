package com.example.clicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.clicker.databinding.ActivityMainBinding
import com.example.clicker.presenter.Presenter
import com.example.clicker.view.CounterView

class MainActivity : AppCompatActivity(), CounterView {

    private lateinit var binding: ActivityMainBinding
    private var presenter = Presenter()
    private var timer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachVIew(this)
        initClick()
    }

    private fun startCountDownTimer(timerMillis: Long) {
        timer?.cancel()
        timer = object : CountDownTimer(timerMillis, 100) {
            override fun onTick(timeM: Long) {
                binding.tvTimer.text = timeM.toString()
            }

            override fun onFinish() {
                binding.tvTimer.text = "Finish"
            }
        }.start()
    }

    fun initClick() {
        binding.btnClick.setOnClickListener {
            if (binding.tvCllick.text == "0") {
                startCountDownTimer(2000)
            }
            if (binding.tvTimer.text != "Finish") {
                presenter.incrementCount()
            }
        }
    }

    override fun updateText(count: String) {
        binding.tvCllick.text = count
    }
}