package com.example.petprojectlistfilms.domain.userUseCases

import com.example.petprojectlistfilms.domain.Repository

class DeleteUserUseCase(private val repository: Repository) {
    fun deleteUser(token: String){
        repository.deleteUser(token)
    }
}