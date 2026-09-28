package com.example.cherepeninpr01.remote

import com.example.cherepeninpr01.model.RecipeResponse
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path
import com.example.cherepeninpr01.model.Recipe

interface RecipeApi {
    @GET("recipes")
    suspend fun getRecipes(): RecipeResponse

    @DELETE("recipes/{id}")
    suspend fun deleteRecipes(@Path("id") id: Int): Recipe
}