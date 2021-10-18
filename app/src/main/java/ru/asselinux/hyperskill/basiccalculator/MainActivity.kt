package ru.asselinux.hyperskill.basiccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    enum class Action {NONE, ADD, SUBTRACT, MULTIPLY, DIVIDE}
    var action = Action.NONE
    var firstValue : Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clearButton.setOnClickListener {
            clear(true)
        }
        equalButton.setOnClickListener {
            editText.hint = "0"
            when (action) {
                Action.NONE -> {}
                Action.ADD -> {editText.setText("${add(firstValue, editText.text.toString().toDouble())}")}
                Action.SUBTRACT -> {editText.setText("${subtract(firstValue, editText.text.toString().toDouble())}")}
                Action.MULTIPLY -> {editText.setText("${multiply(firstValue, editText.text.toString().toDouble())}")}
                Action.DIVIDE -> {editText.setText("${divide(firstValue, editText.text.toString().toDouble())}")}
            }
        }
        addButton.setOnClickListener {
            action = Action.ADD
            saveAndUpdateUI()
        }
        subtractButton.setOnClickListener {
            action = Action.SUBTRACT
            saveAndUpdateUI()
        }
        multiplyButton.setOnClickListener {
            action = Action.MULTIPLY
            saveAndUpdateUI()
        }
        divideButton.setOnClickListener {
            action = Action.DIVIDE
            saveAndUpdateUI()
        }

        button0.setOnClickListener {
            if (editText.text.toString() != "0") {
                editText.setText("${editText.text}0")
            }
        }
        button1.setOnClickListener {
            editText.setText("${editText.text}1")
        }
        button2.setOnClickListener {
            editText.setText("${editText.text}2")
        }
        button3.setOnClickListener {
            editText.setText("${editText.text}3")
        }
        button4.setOnClickListener {
            editText.setText("${editText.text}4")
        }
        button5.setOnClickListener {
            editText.setText("${editText.text}5")
        }
        button6.setOnClickListener {
            editText.setText("${editText.text}6")
        }
        button7.setOnClickListener {
            editText.setText("${editText.text}7")
        }
        button8.setOnClickListener {
            editText.setText("${editText.text}8")
        }
        button9.setOnClickListener {
            editText.setText("${editText.text}9")
        }
        dotButton.setOnClickListener {
            if (!editText.text.toString().contains(".")){
                editText.setText("${editText.text}.")
            }
        }
    }

    fun add(x: Double, y: Double) : String {
        return checkDecimal(x + y)
    }

    fun subtract(x: Double, y: Double) : String {
        return checkDecimal(x - y)
    }

    fun multiply(x: Double, y: Double) : String {
        return checkDecimal(x * y)
    }

    fun divide(x: Double, y: Double) : String {
        return checkDecimal(x / y)
    }

    fun saveAndUpdateUI() {

        if (action == Action.SUBTRACT && editText.text.toString() == "") {
            action = Action.NONE
            editText.setText("-")
        }
        else if (editText.text.toString() != "") {
            firstValue = editText.text.toString().toDouble()
            editText.hint = "${checkDecimal(firstValue)}"
            clear(false)
        }
    }

    fun clear(clearAll: Boolean) {
        if (clearAll) {
            editText.hint = "0"
        }
        editText.setText("")
    }

    fun checkDecimal(number: Double) : String {
        var decimal = number.toString().substringAfterLast(".")
        if (decimal == "0") {
            return number.toLong().toString()
        } else {
            return number.toString()
        }
    }

}
