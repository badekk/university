package com.pjatk.bmi.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.pjatk.bmi.R

class BMICalculatorFragment : Fragment() {
    private lateinit var ageEdit: EditText
    private lateinit var weightEdit: EditText
    private lateinit var heightEdit: EditText
    private lateinit var bmiResultTextView: TextView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_bmi_calculator, container, false)

        ageEdit = view.findViewById(R.id.ageEditText)
        weightEdit = view.findViewById(R.id.weightEditText)
        heightEdit = view.findViewById(R.id.heightEditText)
        bmiResultTextView = view.findViewById(R.id.resultTextView)
        val btnCalculate: Button = view.findViewById(R.id.btn_calculate_bmi)

        btnCalculate.setOnClickListener(buttonCalculateListener)

        return view
    }

    private fun calculate() {
        val weight = weightEdit.text.toString().toFloat()
        val height = heightEdit.text.toString().toFloat() / 100
        val age = ageEdit.text.toString().toInt()
        val bmi = weight / (height * height)

        val score = assessBmiScore(age, bmi)

        val result = "Your BMI is: %.2f, %s".format(bmi, score)

        bmiResultTextView.text = result
    }

    private val buttonCalculateListener = View.OnClickListener { calculate() }

    private fun assessBmiScore(age: Int, bmi: Float): String {
        val score: String
        score = if (age < 25) {
            when {
                bmi < 19 -> getUnderweightStatus()
                bmi > 24 -> getOverweightStatus()
                else -> getHealthyweightStatus()
            }
        } else if (age > 65) {
            when {
                bmi < 24 -> getUnderweightStatus()
                bmi > 29 -> getOverweightStatus()
                else -> getHealthyweightStatus()
            }
        } else {
            when {
                bmi < 20 -> getUnderweightStatus()
                bmi > 28 -> getOverweightStatus()
                else -> getHealthyweightStatus()
            }
        }
        return score
    }

    private fun getHealthyweightStatus(): String {
        return resources.getString(R.string.bmi_score_healthy_weight)
    }

    private fun getOverweightStatus(): String {
        return resources.getString(R.string.bmi_score_overweight)
    }

    private fun getUnderweightStatus(): String {
        return resources.getString(R.string.bmi_score_underweight)
    }
}