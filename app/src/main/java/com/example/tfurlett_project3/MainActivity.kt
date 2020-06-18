package com.example.tfurlett_project3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
// Expression Builder
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Operator functions
        button_plus.setOnClickListener {
            calcExpression("+", clear = true)
        }
        button_min.setOnClickListener {
            calcExpression("-", clear = true)
        }
        button_mult.setOnClickListener {
            calcExpression("*", clear = true)
        }
        button_div.setOnClickListener {
            calcExpression("/", clear = true)
        }
        button_dec.setOnClickListener {
            calcExpression(".", clear = true)
        }

        // for the enter button, uses the Expression Builder library to do the calculation
        button_enter.setOnClickListener {
            val text = calcOutput.text.toString()
            val expression = ExpressionBuilder(text).build()
            val result = expression.evaluate()
            val decResult = result.toLong()

            if (result == decResult.toDouble()) {
                calcInput.text = decResult.toString()
            }
            else {
                calcInput.text = result.toString()
            }
        }

        //could not get this function working
        // This is supposed to be a backspace when inputting the expression
        button_del.setOnClickListener {

        }
        button_clear.setOnClickListener {
            calcOutput.text = ""
            calcInput.text = ""
        }

        // Number Buttons
        button_one.setOnClickListener {
            calcExpression("1", clear = true)
        }
        button_two.setOnClickListener {
            calcExpression("2", clear = true)
        }
        button_three.setOnClickListener {
            calcExpression("3", clear = true)
        }
        button_four.setOnClickListener {
            calcExpression("4", clear = true)
        }
        button_five.setOnClickListener {
            calcExpression("5", clear = true)
        }
        button_six.setOnClickListener {
            calcExpression("6", clear = true)
        }
        button_seven.setOnClickListener {
            calcExpression("7", clear = true)
        }
        button_eight.setOnClickListener {
            calcExpression("8", clear = true)
        }
        button_nine.setOnClickListener {
            calcExpression("9", clear = true)
        }
        button_zero.setOnClickListener {
            calcExpression("0", clear = true)
        }

    }

    /**
     * @brief This function takes the expression builder library and uses it to create the output for the calculator
     * @param evalInput is the input expression that is to be evaluated
     * @param clear checks if the evaluation string that is sent to this function is empty
     */
    fun calcExpression(evalInput: String, clear: Boolean) {
        if(clear) {
            calcInput.text = ""
            calcOutput.append(evalInput)
        }
        else {
            calcOutput.append(calcInput.text)
            calcOutput.append(evalInput)
            calcInput.text = ""
        }
    }








}
