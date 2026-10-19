package com.example.cherepeninpr01.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.cherepeninpr01.auth.TokenManager
import com.example.cherepeninpr01.model.AuthRequest
import com.example.cherepeninpr01.model.AuthResponse
import com.example.cherepeninpr01.model.PostsResponse
import com.example.cherepeninpr01.repository.PostRepository
import kotlinx.coroutines.launch

class PostsViewModel(application: Application) : AndroidViewModel(application) {

    private val email = "dima.cherepenin.official2@gmail.com"
    private val password = "12345678910"
    private val repository = PostRepository()

    // ← объект прямо во ViewModel
    private val tokenManager = TokenManager(application.applicationContext)

    fun loadPosts() {
        viewModelScope.launch {
            try {
                val token = getOrRefreshToken() ?: run {
                    Log.e("POSTS", "Не удалось получить токен")
                    return@launch
                }

                val postsResult: PostsResponse = repository.getPosts("Bearer $token")

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
        }
    }

    private suspend fun getOrRefreshToken(): String? {
        tokenManager.getToken()?.let {
            Log.d("POSTS", "Используем сохранённый токен: ${it.take(20)}...")
            return it
        }

        return try {
            val authResult: AuthResponse = repository.auth(
                AuthRequest(identity = email, password = password)
            )

            tokenManager.saveToken(authResult.token)

            Log.d(
                "POSTS",
                "Успешная авторизация:\n" +
                        "ID: ${authResult.record.id}\n" +
                        "Email: ${authResult.record.email}\n" +
                        "Token: ${authResult.token.take(20)}..."
            )
            authResult.token
        } catch (ex: Exception) {
            Log.e("POSTS", "Ошибка при авторизации", ex)
            null
        }
    }
}