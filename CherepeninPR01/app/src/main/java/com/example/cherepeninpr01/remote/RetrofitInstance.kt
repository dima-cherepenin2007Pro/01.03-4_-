package com.example.cherepeninpr01.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.InetSocketAddress
import java.net.Proxy
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
object RetrofitInstance {
    private const val BASE_URL = "https://dummyjson.com/"

    val proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("10.207.106.59", 3128))

    val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .proxy(proxy)
            .addInterceptor(loggingInterceptor)
            .build()
    }
    private val retrofitClient = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val apiRecipe: RecipeApi by lazy {
        retrofitClient.create(RecipeApi::class.java)
    }
    val apiUser: UserApi by lazy {
        retrofitClient.create(UserApi::class.java)
    }
    val apiProduct: ProductAPI by lazy{
        retrofitClient.create(ProductAPI::class.java)
    }
}