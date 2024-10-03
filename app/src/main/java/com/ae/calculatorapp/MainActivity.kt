package com.ae.calculatorapp

import android.os.Bundle
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
            button.setOnClickListener { }
        }

        // Operator Buttons
        for ((button, value) in operatorButtons) {
            button.setOnClickListener { }
        }


        binding.buttonDot.setOnClickListener {

        }

        binding.buttonClear.setOnClickListener {

        }

        binding.buttonCroxx.setOnClickListener {

        }

        binding.buttonBracket.setOnClickListener {

        }

        binding.buttonBracketR.setOnClickListener {

        }

    }
}