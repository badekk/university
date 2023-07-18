package com.example.bottomNavigation.nav_apps;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bottomNavigation.R;

import java.util.Locale;

public class CaloriesCalculator extends AppCompatActivity {

    private Spinner activityLevelSpinner;
    private EditText ageEditText;
    private EditText weightEditText;
    private EditText heightEditText;
    private RadioGroup genderRadioGroup;
    private Button calculateButton;
    private TextView caloriesNeededTextView;

    private double bmr = 0;
    private double caloriesNeeded = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories);

        activityLevelSpinner = findViewById(R.id.activity_level_spinner);
        ageEditText = findViewById(R.id.edit_text_age);
        weightEditText = findViewById(R.id.edit_text_weight);
        heightEditText = findViewById(R.id.edit_text_height);
        genderRadioGroup = findViewById(R.id.radio_group_gender);
        calculateButton = findViewById(R.id.calculate_button);
        caloriesNeededTextView = findViewById(R.id.calories_needed_text_view);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.activity_levels, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        activityLevelSpinner.setAdapter(adapter);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateCaloriesNeeded();
            }
        });
    }

    private void calculateCaloriesNeeded() {
        int age = Integer.parseInt(ageEditText.getText().toString());
        double weight = Double.parseDouble(weightEditText.getText().toString());
        double height = Double.parseDouble(heightEditText.getText().toString());
        int selectedGender = genderRadioGroup.getCheckedRadioButtonId();
        double activityLevel = getActivityLevelValue(activityLevelSpinner.getSelectedItemPosition());

        if (selectedGender == R.id.radio_button_male) {
            bmr = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
        } else if (selectedGender == R.id.radio_button_female) {
            bmr = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
        }

        caloriesNeeded = bmr * activityLevel;
        caloriesNeededTextView.setText(String.format(Locale.getDefault(), "%.2f", caloriesNeeded));
    }

    private double getActivityLevelValue(int position) {
        double[] values = {1.2, 1.375, 1.55, 1.725, 1.9};
        return values[position];
    }
}