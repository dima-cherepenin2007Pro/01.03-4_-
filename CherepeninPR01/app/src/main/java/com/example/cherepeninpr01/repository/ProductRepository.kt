package com.example.cherepeninpr01.repository

import com.example.cherepeninpr01.model.ProductResponse
import com.example.cherepeninpr01.remote.RetrofitInstance

class ProductRepository {
    suspend fun getProduct(id: Int): ProductResponse{
        return RetrofitInstance.apiProduct.getProduct(id)
    }
    suspend fun changeProduct(product: ProductResponse): ProductResponse{
        return RetrofitInstance.apiProduct.changeProduct(product.id, product)
    }
}