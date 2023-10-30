package com.example.petprojectlistfilms.domain.filmUseCase

import com.example.petprojectlistfilms.domain.Repository
import com.example.petprojectlistfilms.domain.model.Film

class EditFilmUseCase(private val repository: Repository) {
    fun editFilm(film:Film){
        repository.editFilm(film)
    }
}