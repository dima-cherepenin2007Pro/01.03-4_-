package com.example.cherepeninpr01.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.cherepeninpr01.repository.UserRepository
import com.example.cherepeninpr01.model.CreateUserRequest

class UserViewModel : ViewModel() {

    private val repository = UserRepository()

    fun addUser() {

        val user = CreateUserRequest(
            firstName = "Антон",
            lastName = "Кудрин",
            gender = "male",
            address = "г. Заволжье, пр-т Мира, 18"
        )

        viewModelScope.launch {
            try {
                val result = repository.addUser(user)
                Log.d(
                    "USER",
                    "Пользователь добавлен:\n" +
                            "ID: ${result.id}\n" +
                            "Имя: ${result.firstName}\n" +
                            "Фамилия: ${result.lastName}\n" +
                            "Пол: ${result.gender}\n" +
                            "Адрес: ${result.address.city}, ${result.address.address}"
                )
            } catch (e: Exception) {

                Log.e(
                    "USER",
                    "Ошибка при добавлении пользователя",
                    e
                )
            }
        }
    }
}