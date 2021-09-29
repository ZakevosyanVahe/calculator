package com.vmd.mycalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var operator: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var dotUsed: Boolean = false

        val displayTextView: TextView = findViewById(R.id.text_view)

        val zero: Button = findViewById(R.id.button_zero)
        zero.setOnClickListener {
            if (displayTextView.text != "0") {
                displayTextView.text = displayTextView.text.toString().plus(zero.text)
            }
        }
        var clickListener = View.OnClickListener { view ->
            (view as Button)
            if (displayTextView.text == zero.text) {
                displayTextView.text = view.text
            } else {
                displayTextView.text = displayTextView.text.toString().plus(view.text)
            }
        }

        val one: Button = findViewById(R.id.button_one)
        one.setOnClickListener(clickListener)

        val two: Button = findViewById(R.id.button_two)
        two.setOnClickListener(clickListener)
        val three: Button = findViewById(R.id.button_three)
        three.setOnClickListener(clickListener)
        val four: Button = findViewById(R.id.button_four)
        four.setOnClickListener (clickListener)
        val five: Button = findViewById(R.id.button_five)
        five.setOnClickListener(clickListener)
        val six: Button = findViewById(R.id.button_six)
        six.setOnClickListener(clickListener)
        val seven: Button = findViewById(R.id.button_seven)
        seven.setOnClickListener(clickListener)
        val eight: Button = findViewById(R.id.button_eight)
        eight.setOnClickListener(clickListener)
        val nine: Button = findViewById(R.id.button_nine)
        nine.setOnClickListener(clickListener)

        val cancel: Button = findViewById(R.id.button_cancel)
        cancel.setOnClickListener {
            displayTextView.text = "0"
            dotUsed = false
        }

        val dot: Button = findViewById(R.id.button_dot)
        dot.setOnClickListener {
            if (!dotUsed) {
                displayTextView.text = displayTextView.text.toString().plus(dot.text)
                dotUsed = true
            }
        }

        val plus: Button = findViewById(R.id.button_plus)
        plus.setOnClickListener {
            displayTextView.text = displayTextView.text.toString().plus(" + ")
            operator = "+"
            dotUsed = false
        }

        val minus: Button = findViewById(R.id.button_minus)
        minus.setOnClickListener {
            displayTextView.text = displayTextView.text.toString().plus(" - ")
            operator = "-"
            dotUsed = false
        }

        val multiply: Button = findViewById(R.id.button_multiply)
        multiply.setOnClickListener {
            displayTextView.text = displayTextView.text.toString().plus(" * ")
            operator = "*"
            dotUsed = false
        }

        val divide: Button = findViewById(R.id.button_divid)
        divide.setOnClickListener {
            displayTextView.text = displayTextView.text.toString().plus(" / ")
            operator = "/"
            dotUsed = false
        }

        val equal: Button = findViewById(R.id.button_equal)
        equal.setOnClickListener {

            var firstOperand: String = ""
            var secondOperand: String = ""
            var sign: String = ""
            val list: List<String> = displayTextView.text.toString().split(" ")
            firstOperand = list[0].trim()
            secondOperand = list[2].trim()
            sign = list[1]

            when (sign) {
                "+" -> displayTextView.text =
                    (firstOperand.toDouble() + secondOperand.toDouble()).toString()
                "-" -> displayTextView.text =
                    (firstOperand.toDouble() - secondOperand.toDouble()).toString()
                "*" -> displayTextView.text =
                    (firstOperand.toDouble() * secondOperand.toDouble()).toString()
                "/" -> displayTextView.text = if (!secondOperand.equals("0")) {
                    (firstOperand.toDouble() / secondOperand.toDouble()).toString()
                } else {
                    "Can't divide by 0"
                }
            }
        }
    }
}