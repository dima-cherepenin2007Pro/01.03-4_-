package com.example.cherepeninpr01.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.InetSocketAddress
import java.net.Proxy
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
object RetrofitInstance {
    private const val BASE_URL = "https://dummyjson.com/"

    val proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("10.207.106.59", 3128))

    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .proxy(proxy)
            .build()
    }

    val api: RecipeApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RecipeApi::class.java)
    }
}