package com.example.cherepeninpr01.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cherepeninpr01.repository.RecipeRepository
import kotlinx.coroutines.launch

class RecipeViewModel : ViewModel() {

    private val repository = RecipeRepository()

    fun loadRecipes() {
        viewModelScope.launch {
            try {
                val recipes = repository.getRecipes()

                for (recipe in recipes) {
                    Log.d(
                        "RECIPES",
                        "Название: ${recipe.name}\n" +
                                "Ингредиенты: ${recipe.ingredients}\n" +
                                "Калории: ${recipe.caloriesPerServing}\n"
                    )
                }
            } catch (e: Exception) {
                Log.e("RECIPES", "Ошибка при получении рецептов", e)
            }
        }
    }
}