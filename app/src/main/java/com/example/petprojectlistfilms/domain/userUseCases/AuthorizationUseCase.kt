package com.example.petprojectlistfilms.domain.userUseCases

import com.example.petprojectlistfilms.domain.Repository

class AuthorizationUseCase(private val repository: Repository) {
    /**
     * вернет id пользователя
     * для обращания к БД
     */
    fun authorization(login: String, password: String): Int =
        repository.authorization(login, password)
}