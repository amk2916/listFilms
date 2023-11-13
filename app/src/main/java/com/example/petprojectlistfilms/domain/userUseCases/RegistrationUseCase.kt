package com.example.petprojectlistfilms.domain.userUseCases

import com.example.petprojectlistfilms.domain.Repository
import com.example.petprojectlistfilms.domain.model.User

class RegistrationUseCase(private val repository: Repository) {
    fun addUser(user:User): String{
        return repository.addUser(user)
    }
}