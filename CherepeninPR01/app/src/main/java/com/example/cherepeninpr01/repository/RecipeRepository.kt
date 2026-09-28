package com.example.cherepeninpr01.repository

import androidx.navigationevent.NavigationEventInfo
import com.example.cherepeninpr01.model.Recipe
import com.example.cherepeninpr01.remote.RetrofitInstance
import com.example.cherepeninpr01.model.RecipeResponse

class RecipeRepository {
    suspend fun getRecipes(): List<Recipe> {
        return RetrofitInstance.apiRecipe.getRecipes().recipes
    }
    suspend fun deleteRecipe(id: Int): Recipe{
        return RetrofitInstance.apiRecipe.deleteRecipes(id)
    }
}