package com.example.petprojectlistfilms.domain.filmUseCase

import com.example.petprojectlistfilms.domain.Repository
import com.example.petprojectlistfilms.domain.model.Film

class GetFilmsInternetUseCase(private val repository: Repository) {
    fun getFilmsInternet():List<Film>  = repository.getFilmsInternet()
}