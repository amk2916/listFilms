package com.example.petprojectlistfilms.domain.filmUseCase

import com.example.petprojectlistfilms.domain.Repository
import com.example.petprojectlistfilms.domain.model.Film

class GetFilmsDBUseCase(private val repository: Repository) {
    fun getFilms():List<Film> = repository.getFilms()
}