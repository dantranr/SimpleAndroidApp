package com.example.tipcalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

public inline fun String.toDouble(): Double = java.lang.Double.parseDouble(this)

class MainActivity : AppCompatActivity() {
    var tipPercent = 0
    var totalAmount = 0.0
    var tipAmount = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Display the Tip Percentage seek bar
        val seekBar = findViewById<SeekBar>(R.id.tip_percent)
        seekBar?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                tipPercent = seekBar.progress
                text_seekpercentage.text = tipPercent.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                //for debug
                //Toast.makeText(this@MainActivity, "Tip Percentage is " + seekBar.progress + "%", Toast.LENGTH_SHORT).show()
            }
        })

        // Action on the calculate button
        cal_button.setOnClickListener {
            val tipPercentDouble: Double = tipPercent.toDouble()
            val totalBill = total_bill.text.toString().toDouble()
            tipAmount = (totalBill * tipPercentDouble) / 100
            totalAmount = totalBill + tipAmount
            totalAmount = Math.round(totalAmount * 100.0) / 100.0
            tipAmount = Math.round(tipAmount * 100.0) / 100.0
            tip_amount.text = tipAmount.toString()
            total_amount.text = totalAmount.toString()
        }

    }
}
