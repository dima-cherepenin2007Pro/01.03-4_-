package com.example.cherepeninpr01.remote

import com.example.cherepeninpr01.model.RecipeResponse
import retrofit2.http.GET

interface RecipeApi {
    @GET("recipes")
    suspend fun getRecipes(): RecipeResponse
}