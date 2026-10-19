package com.example.cherepeninpr01.remote

import android.webkit.HttpAuthHandler
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.InetSocketAddress
import java.net.Proxy
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit


object RetrofitPosts {
    private const val BASE_URL = "http://10.207.106.59:8090/"

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

    val apiPost: PostAPI by lazy {
        retrofitClient.create(PostAPI::class.java)
    }
}