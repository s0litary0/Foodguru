package com.example.foodguru

import android.app.Application
import com.example.foodguru.data.RecipeRepository

class FoodguruApplication : Application() {

    val recipeRepository: RecipeRepository by lazy {
        RecipeRepository()
    }
}