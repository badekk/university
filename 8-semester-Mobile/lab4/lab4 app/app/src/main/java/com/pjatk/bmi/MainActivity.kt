package com.pjatk.bmi

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pjatk.bmi.ui.fragment.BMICalculatorFragment
import com.pjatk.bmi.ui.fragment.CaloriesFragment
import com.pjatk.bmi.ui.fragment.ChartFragment
import com.pjatk.bmi.ui.fragment.QuizFragment
import com.pjatk.bmi.ui.fragment.RecipeFragment

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var bottomNavigationView: BottomNavigationView

    private val bmiCalculatorFragment = BMICalculatorFragment()
    private val caloriesFragment = CaloriesFragment()
    private val recipeFragment = RecipeFragment()
    private val chartFragment = ChartFragment()
    private val quizFragment = QuizFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)

        bottomNavigationView.setOnNavigationItemSelectedListener(this)
        bottomNavigationView.setSelectedItemId(R.id.navigation_bmi_calc)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigation_bmi_calc -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, bmiCalculatorFragment)
                        .commit()
                return true
            }
            R.id.navigation_calories -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, caloriesFragment)
                        .commit()
                return true
            }
            R.id.navigation_recipe -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, recipeFragment)
                        .commit()
                return true
            }
            R.id.navigation_chart -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, chartFragment)
                        .commit()
                return true
            }
            R.id.navigation_quiz -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, quizFragment)
                        .commit()
                return true
            }
        }
        return false
    }
}
