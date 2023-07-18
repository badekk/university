package com.example.bottomNavigation.nav_apps;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bottomNavigation.R;

public class Recipe extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        Button recipeOneButton = findViewById(R.id.recipeOneButton);
        recipeOneButton.setOnClickListener(this);

        Button recipeTwoButton = findViewById(R.id.recipeTwoButton);
        recipeTwoButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.recipeOneButton:
                showRecipeOne();
                break;
            case R.id.recipeTwoButton:
                showRecipeTwo();
                break;
            default:
                break;
        }
    }

    private void showRecipeOne() {
        // Create a dialog to display the recipe
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Recipe One: Grilled Chicken Salad");

        // Set the message of the dialog to the recipe text
        String recipeOne = "Ingredients:\n" +
                "- Grilled chicken breast\n" +
                "- Mixed greens\n" +
                "- Cherry tomatoes\n" +
                "- Cucumber\n" +
                "- Red onion\n" +
                "- Low-fat vinaigrette\n\n" +
                "Instructions:\n" +
                "1. Grill the chicken breast until fully cooked.\n" +
                "2. Wash and chop the mixed greens, cherry tomatoes, cucumber, and red onion.\n" +
                "3. Slice the grilled chicken breast into bite-sized pieces.\n" +
                "4. Toss the mixed greens, cherry tomatoes, cucumber, and red onion with the low-fat vinaigrette.\n" +
                "5. Top the salad with the sliced grilled chicken breast.\n" +
                "6. Serve and enjoy!";
        builder.setMessage(recipeOne);

        // Set the button of the dialog and show it
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showRecipeTwo() {
        // Create a dialog to display the recipe
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Recipe Two: Vegetarian Chili");

        // Set the message of the dialog to the recipe text
        String recipeTwo = "Ingredients:\n" +
                "- Black beans\n" +
                "- Kidney beans\n" +
                "- Diced tomatoes\n" +
                "- Red onion\n" +
                "- Bell pepper\n" +
                "- Garlic\n" +
                "- Chili powder\n" +
                "- Cumin\n" +
                "- Salt\n\n" +
                "Instructions:\n" +
                "1. Rinse and drain the black beans and kidney beans.\n" +
                "2. Dice the red onion and bell pepper.\n" +
                "3. Mince the garlic.\n" +
                "4. In a large pot, sauté the red onion, bell pepper, and garlic until tender.\n" +
                "5. Add the black beans, kidney beans, diced tomatoes, chili powder, cumin, and salt to the pot.\n" +
                "6. Simmer the chili for 20-30 minutes until it thickens.\n" +
                "7. Serve and enjoy!";
        builder.setMessage(recipeTwo);

        // Set the button of the dialog and show it
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
