package com.pjatk.bmi.model

class Recipe(private val title: String, private val ingredients: Array<String>, private val instructions: Array<String>) {
    fun getTitle(): String {
        return title
    }

    fun getIngredients(): Array<String> {
        return ingredients
    }

    fun getInstructions(): Array<String> {
        return instructions
    }
}
