package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var num1:EditText? = null
    private var num2:EditText? = null
    private var btnSum:Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Calculator)
        setContentView(R.layout.activity_main)
        num1 = findViewById(R.id.num1)
        num2 = findViewById(R.id.num2)
        btnSum = findViewById(R.id.buttonSum)
        btnSum?.setOnClickListener {
            run {
                if (checkAllFields()) {
                    try {
                        val number1: Long = (num1?.text.toString().toLong())
                        val number2: Long = (num2?.text.toString().toLong())
                        Toast.makeText(
                            this@MainActivity,
                            "${getString(R.string.sum_equal)} ${number1 + number2}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }catch (ex:NumberFormatException){
                        Toast.makeText(
                            this@MainActivity,
                            getString(R.string.the_number_is_too_long),
                            Toast.LENGTH_SHORT
                        ).show()
                    }finally {
                        num1?.setText("")
                        num2?.setText("")
                    }
                }
            }
        }

    }

    private fun checkAllFields(): Boolean {
        if (num1?.length()==0) {
            num1?.error = getString(R.string.required)
            return false
        }
        if (num2?.length()==0 ) {
            num2?.error = getString(R.string.required)
            return false
        }

        return true
    }
}