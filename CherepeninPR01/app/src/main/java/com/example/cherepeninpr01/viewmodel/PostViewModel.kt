package com.example.cherepeninpr01.viewmodel

import android.util.Log
import androidx.compose.runtime.saveable.autoSaver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cherepeninpr01.model.AuthRequest
import com.example.cherepeninpr01.repository.RecipeRepository
import kotlinx.coroutines.launch
import com.example.cherepeninpr01.model.AuthResponse
import com.example.cherepeninpr01.model.PostsResponse
import com.example.cherepeninpr01.repository.PostRepository

class PostsViewModel : ViewModel() {
    private val email = "dima.cherepenin.official2@gmail.com"
    private val password = "12345678910"
    private val repository = PostRepository()

    fun loadPosts() {
        viewModelScope.launch{
            val authResult: AuthResponse
            val authData = AuthRequest(
                identity = email,
                password = password
            )
            try {
                authResult = repository.auth(authData)
                Log.d(
                    "POSTS",
                    "Успешная авторизация:\n" +
                            "ID: ${authResult.record.id}\n" +
                            "Email: ${authResult.record.email}\n" +
                            "Имя: ${authResult.record.firstName} ${authResult.record.lastName}\n" +
                            "Token: ${authResult.token.take(20)}..."
                )
                val postsResult: PostsResponse
                try {
                    val bearerToken = "Bearer ${authResult.token}"
                    postsResult = repository.getPosts(bearerToken)

                    Log.d(
                        "POSTS",
                        "Данные о публикациях:\n" +
                                "Всего записей: ${postsResult.totalItems}\n" +
                                "Страница: ${postsResult.page} из ${postsResult.totalPages}\n" +
                                "На странице: ${postsResult.perPage}"
                    )
                    postsResult.items.forEachIndexed { index, post ->
                        Log.d(
                            "POSTS",
                            "Публикация #${index + 1}:\n" +
                                    "ID: ${post.id}\n" +
                                    "title: ${post.title}\n" +
                                    "body: ${post.body}\n" +
                                    "created: ${post.created}\n" +
                                    "updated: ${post.updated}"
                        )
                    }
                } catch (ex: Exception) {
                    Log.e("POSTS", "Ошибка при получении публикаций", ex)
                }
            } catch (ex: Exception) {
                Log.e("POSTS", "Ошибка при авторизации", ex)
            }
        }
    }
}