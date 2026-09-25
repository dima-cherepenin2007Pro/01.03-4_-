package com.example.cherepeninpr01.viewmodel

import android.icu.text.ListFormatter
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cherepeninpr01.model.ChangeProductRequest
import com.example.cherepeninpr01.repository.RecipeRepository
import kotlinx.coroutines.launch
import com.example.cherepeninpr01.repository.ProductRepository

class ProductViewModel : ViewModel() {
    private val repository = ProductRepository()
    fun changeProduct(){

        val product = ChangeProductRequest(
            id = 48,
            title = "Беспроводные наушники SoundWave Pro",
            description = "Наушники с активным шумоподавлением, влагозащитой IPX4 и автономностью до 30 часов работы вместе с кейсом",
            category = "Аудиотехника",
            tags = listOf("Наушники", "bluetooth", "беспроводные наушники", "гаджеты")
        )

        viewModelScope.launch {
            try{
                val result = repository.getProduct(48)
                Log.d(
                    "PRODUCT",
                    "Данные о товаре:\n" +
                            "ID: ${result.id}\n" +
                            "title: ${result.title}\n" +
                            "description: ${result.description}\n" +
                            "category: ${result.category}\n" +
                            "tags: ${result.tags}\n"
                )
            }
            catch(ex: Exception){
                Log.e(
                    "Product",
                    "Ошибка при получении товара",
                    ex
                )
            }
            try{
                val result = repository.changeProduct(product)
                Log.d(
                    "PRODUCT",
                    "Данные о товаре изменены:\n" +
                            "ID: ${result.id}\n" +
                            "title: ${result.title}\n" +
                            "description: ${result.description}\n" +
                            "category: ${result.category}\n" +
                            "tags: ${result.tags}\n"
                )
            }
            catch (ex: Exception){
                Log.e(
                    "Product",
                    "Ошибка при изменении товара",
                    ex
                )
            }
        }
    }
}