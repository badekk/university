package com.example.bottomNavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.bottomNavigation.nav_apps.BmiCalc;
import com.example.bottomNavigation.nav_apps.CaloriesCalculator;
import com.example.bottomNavigation.nav_apps.Recipe;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Find the BottomNavigationView in the layout
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set the listener for the BottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Handle the navigation item clicks here
                switch (item.getItemId()) {
                    case R.id.nav_bmi_calculator:
                        // Launch the BMI calculator screen
                        Intent intent1 = new Intent(MainActivity.this, BmiCalc.class);
                        startActivity(intent1);
                        return true;
                    case R.id.nav_calories_calculator:
                        // Launch the calories calculator screen
                        Intent intent2 = new Intent(MainActivity.this, CaloriesCalculator.class);
                        startActivity(intent2);
                        return true;
                    case R.id.nav_recipes:
                        // Launch the recipes screen
                        Intent intent3 = new Intent(MainActivity.this, Recipe.class);
                        startActivity(intent3);
                        return true;
                    default:
                        return false;
                }
            }
        });

        // Set the icons for the BottomNavigationView menu items
        bottomNavigationView.getMenu().findItem(R.id.nav_bmi_calculator).setIcon(R.drawable.bmi_icon);
        bottomNavigationView.getMenu().findItem(R.id.nav_calories_calculator).setIcon(R.drawable.calories_icon);
        bottomNavigationView.getMenu().findItem(R.id.nav_recipes).setIcon(R.drawable.recipes_icon);
    }
}