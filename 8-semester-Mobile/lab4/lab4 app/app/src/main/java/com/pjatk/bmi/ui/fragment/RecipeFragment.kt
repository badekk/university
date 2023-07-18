package com.pjatk.bmi.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.pjatk.bmi.R
import com.pjatk.bmi.model.Recipe

class RecipeFragment : Fragment() {
    private lateinit var recipeTextView: TextView
    private lateinit var showRecipeButton: Button
    private lateinit var recipeSpinner: Spinner
    private val recipeList = ArrayList<com.pjatk.bmi.model.Recipe>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_recipe, container, false)

        recipeList.add(com.pjatk.bmi.model.Recipe("Baked Lemon Herb Chicken",
                resources.getStringArray(R.array.recipe_ingredients_baked_lemon_herb_chicken),
                resources.getStringArray(R.array.recipe_instructions_baked_lemon_herb_chicken)))
        recipeList.add(com.pjatk.bmi.model.Recipe("T.C.A. salad",
                resources.getStringArray(R.array.recipe_ingredients_tomato_cucumber_and_avocado_salad),
                resources.getStringArray(R.array.recipe_instructions_tomato_cucumber_and_avocado_salad)))

        recipeTextView = view.findViewById(R.id.recipeTextView)
        showRecipeButton = view.findViewById(R.id.showRecipeButton)
        recipeSpinner = view.findViewById(R.id.recipeSpinner)

        showRecipeButton.setOnClickListener {
            val selectedRecipeIndex = recipeSpinner.selectedItemPosition
            val selectedRecipe = recipeList[selectedRecipeIndex]
            val sb = StringBuilder()
            sb.append("INGREDIENTS:").append("\n")
            for (ingredient in selectedRecipe.ingredients) {
                sb.append(ingredient).append("\n")
            }
            sb.append("INSTRUCTIONS:").append("\n")
            for (instruction in selectedRecipe.instructions) {
                sb.append(instruction).append("\n")
            }
            recipeTextView.text = sb.toString()
        }

        return view
    }
}
