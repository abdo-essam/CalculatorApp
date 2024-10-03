package com.ae.calculatorapp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.ae.calculatorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)

        setButtonListeners()

        binding.buttonEquals.setOnClickListener {

        }

    }

    private fun setButtonListeners() {
        val numberButtons = listOf(
            binding.button0 to "0", binding.button1 to "1", binding.button2 to "2",
            binding.button3 to "3", binding.button4 to "4", binding.button5 to "5",
            binding.button6 to "6", binding.button7 to "7", binding.button8 to "8",
            binding.button9 to "9"
        )

        val operatorButtons = listOf(
            binding.buttonAddition to "+", binding.buttonSubtraction to "-",
            binding.buttonMultiply to "×", binding.buttonDivision to "÷"
        )

        // Number Buttons
        for ((button, value) in numberButtons) {
            button.setOnClickListener {
                appendToInput(value)
            }
        }

        // Operator Buttons
        for ((button, value) in operatorButtons) {
            button.setOnClickListener {
                appendToInput(value, true)
            }
        }


        binding.buttonDot.setOnClickListener {
            if (!binding.input.text.toString().contains(".")) {
                appendToInput(".")
            }
        }

        binding.buttonClear.setOnClickListener {
            clearInput()
        }

        binding.buttonCroxx.setOnClickListener {
            removeLastCharacter()
        }

        binding.buttonBracket.setOnClickListener {
            appendToInput("(")
        }

        binding.buttonBracketR.setOnClickListener {
            appendToInput(")")
        }

    }


    private fun appendToInput(value: String, isOperator: Boolean = false) {
        if (isOperator) {
            // Avoid consecutive operators
            val inputText = binding.input.text.toString()
            if (inputText.isNotEmpty() && !isOperator(inputText.last())) {
                binding.input.text = buildString {
                    append(inputText)
                    append(value)
                }
            }
        } else {
            binding.input.text = buildString {
                append(binding.input.text.toString())
                append(value)
            }
        }
    }

    private fun isOperator(char: Char): Boolean {
        return char == '+' || char == '-' || char == '×' || char == '÷'
    }

    private fun clearInput() {
        binding.input.text = ""
        binding.output.text = ""
    }

    private fun removeLastCharacter() {
        val text = binding.input.text.toString()
        if (text.isNotEmpty()) {
            binding.input.text = text.dropLast(1)
        }
    }


}