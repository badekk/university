package com.pjatk.bmi.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.pjatk.bmi.R

class CaloriesFragment : Fragment() {

    private lateinit var ageEdit: EditText
    private lateinit var weightEdit: EditText
    private lateinit var heightEdit: EditText
    private lateinit var caloriesResultTextView: TextView

    private lateinit var genderDropdownList: Spinner

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_calories, container, false)

        ageEdit = view.findViewById(R.id.ageEditText)
        weightEdit = view.findViewById(R.id.weightEditText)
        heightEdit = view.findViewById(R.id.heightEditText)
        caloriesResultTextView = view.findViewById(R.id.caloriesResultTextView)

        genderDropdownList = view.findViewById(R.id.genderDropdownList)
        ArrayAdapter.createFromResource(
                requireContext(),
                R.array.gender_dropdown,
                android.R.layout.simple_spinner_dropdown_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            genderDropdownList.adapter = adapter
        }

        val btnCalculate: Button = view.findViewById(R.id.btn_calculate_bmi)
        btnCalculate.setOnClickListener { calculate() }

        return view
    }

    private fun calculate() {
        val gender = Gender.valueOf(genderDropdownList.selectedItem.toString().toUpperCase())
        val weight = weightEdit.text.toString().toFloat()
        val height = heightEdit.text.toString().toFloat()
        val age = ageEdit.text.toString().toInt()

        val result: String = if (gender == Gender.MALE) {
            String.format("%.2f", 66.47f + (13.7f * weight) + (5.0f * height) - (6.76f * age))
        } else {
            String.format("%.2f", 655.1f + (9.567f * weight) + (1.85f * height) - (4.68f * age))
        }

        caloriesResultTextView.text = result
    }

    enum class Gender {
        MALE, FEMALE
    }
}
