package com.example.cherepeninpr01.repository

import com.example.cherepeninpr01.model.Recipe
import com.example.cherepeninpr01.remote.RetrofitInstance

class RecipeRepository {
    suspend fun getRecipes(): List<Recipe> {
        return RetrofitInstance.api1.getRecipes().recipes
    }
}