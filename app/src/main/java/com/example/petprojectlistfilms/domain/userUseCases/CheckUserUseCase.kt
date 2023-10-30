package com.example.petprojectlistfilms.domain.userUseCases

import com.example.petprojectlistfilms.domain.Repository

class CheckUserUseCase(private val repository: Repository) {

    fun check(login: String, password: String): Boolean{
        return repository.check(login, password)
    }
}