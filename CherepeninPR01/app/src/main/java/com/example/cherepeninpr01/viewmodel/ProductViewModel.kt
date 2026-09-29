package com.example.cherepeninpr01.viewmodel

import android.icu.text.ListFormatter
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cherepeninpr01.model.ProductResponse
import com.example.cherepeninpr01.model.RecipeResponse
import com.example.cherepeninpr01.repository.RecipeRepository
import kotlinx.coroutines.launch
import com.example.cherepeninpr01.repository.ProductRepository

class ProductViewModel : ViewModel() {
    private val repository = ProductRepository()
    fun changeProduct(){

        viewModelScope.launch {
            val result: ProductResponse
            val modifiedResult: ProductResponse
            try{
                result = repository.getProduct(48)
                Log.d(
                    "PRODUCT",
                    "Данные о товаре:\n" +
                            "ID: ${result.id}\n" +
                            "title: ${result.title}\n" +
                            "description: ${result.description}\n" +
                            "category: ${result.category}\n" +
                            "tags: ${result.tags}\n"
                )
                modifiedResult = result.copy(
                    title = "Беспроводные наушники SoundWave Pro",
                    description = "Наушники с активным шумоподавлением, влагозащитой IPX4 и автономностью до 30 часов работы вместе с кейсом",
                    category = "Аудиотехника",
                    tags = listOf("Наушники", "Bluetooth", "шумоподавление", "беспроводные наушники", "гаджеты"))
                try{
                    val result = repository.changeProduct(modifiedResult)
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
            catch(ex: Exception){
                Log.e(
                    "Product",
                    "Ошибка при получении товара",
                    ex
                )
            }
        }
    }
}