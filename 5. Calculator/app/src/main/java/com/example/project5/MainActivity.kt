package com.example.project5

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var display: TextView
    private var currentOp: String? = null
    private var firstValue: Double = 0.0
    private var secondValue: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.display)

        // Set up number and operator buttons
        setupNumberButtons()
        setupOperatorButtons()
    }

    private fun setupNumberButtons() {
        val numberButtonIds = listOf(
            R.id.button0, R.id.button1, R.id.button2, R.id.button3,
            R.id.button4, R.id.button5, R.id.button6, R.id.button7,
            R.id.button8, R.id.button9
        )

        val listener = View.OnClickListener { v ->
            val button = v as Button
            val currentText = display.text.toString()
            display.text = if (currentText == "0") button.text else currentText + button.text
        }

        for (id in numberButtonIds) {
            findViewById<Button>(id).setOnClickListener(listener)
        }
    }

    private fun setupOperatorButtons() {
        findViewById<Button>(R.id.buttonPlus).setOnClickListener { performOperation("+") }
        findViewById<Button>(R.id.buttonMinus).setOnClickListener { performOperation("-") }
        findViewById<Button>(R.id.buttonMultiply).setOnClickListener { performOperation("*") }
        findViewById<Button>(R.id.buttonDivide).setOnClickListener { performOperation("/") }
        findViewById<Button>(R.id.buttonEquals).setOnClickListener { calculateResult() }
        findViewById<Button>(R.id.buttonClear).setOnClickListener { clear() }
    }

    private fun performOperation(operation: String) {
        firstValue = display.text.toString().toDoubleOrNull() ?: 0.0
        currentOp = operation
        display.text = "0"
    }

    private fun calculateResult() {
        secondValue = display.text.toString().toDoubleOrNull() ?: 0.0
        val result = when (currentOp) {
            "+" -> firstValue + secondValue
            "-" -> firstValue - secondValue
            "*" -> firstValue * secondValue
            "/" -> if (secondValue != 0.0) firstValue / secondValue else {
                display.text = "Error"
                return
            }
            else -> 0.0
        }
        display.text = result.toString()
    }

    private fun clear() {
        display.text = "0"
        firstValue = 0.0
        secondValue = 0.0
        currentOp = null
    }
}
