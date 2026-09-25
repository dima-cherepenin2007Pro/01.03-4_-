package com.example.cherepeninpr01.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cherepeninpr01.model.UserAddress
import kotlinx.coroutines.launch
import com.example.cherepeninpr01.repository.UserRepository
import com.example.cherepeninpr01.model.User

class UserViewModel : ViewModel() {

    private val repository = UserRepository()

    fun addUser() {

        val addr = UserAddress(
            city = "г. Заволжье",
            address = "пр-т Мира, 18"
        )

        val user = User(
            firstName = "Антон",
            lastName = "Кудрин",
            gender = "мужской",
            address = addr
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