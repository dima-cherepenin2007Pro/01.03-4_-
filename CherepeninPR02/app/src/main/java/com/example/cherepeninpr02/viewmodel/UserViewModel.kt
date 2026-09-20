package com.example.cherepeninpr02.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cherepeninpr02.model.CreateUserRequest
import com.example.cherepeninpr02.repository.UserRepository
import kotlinx.coroutines.launch

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