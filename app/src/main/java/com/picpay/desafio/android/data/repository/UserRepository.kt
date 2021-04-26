package com.picpay.desafio.android.data.repository

import com.picpay.desafio.android.model.User

abstract class UserRepository {
    abstract suspend fun getUsers(): List<User>
}