package com.example.petprojectlistfilms.domain.userUseCases

import com.example.petprojectlistfilms.domain.Repository
import com.example.petprojectlistfilms.domain.model.User

class EditUserUseCase(private val repository: Repository) {
    fun editUser(user:User) {
        repository.editUser(user)
    }
}