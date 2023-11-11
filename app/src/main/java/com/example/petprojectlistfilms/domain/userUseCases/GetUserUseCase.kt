package com.example.petprojectlistfilms.domain.userUseCases

import com.example.petprojectlistfilms.domain.Repository
import com.example.petprojectlistfilms.domain.model.User

class GetUserUseCase(private val repository: Repository) {

    fun check(login: String, password: String): User{
        return repository.getUser(login, password)
    }
}