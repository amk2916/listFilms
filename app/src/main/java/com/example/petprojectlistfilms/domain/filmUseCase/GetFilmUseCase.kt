package com.example.petprojectlistfilms.domain.filmUseCase

import com.example.petprojectlistfilms.domain.Repository
import com.example.petprojectlistfilms.domain.model.Film

class GetFilmUseCase(private val repository: Repository) {
    fun  getFilm(idFilm: Int): Film{
        return repository.getFilm(idFilm)
    }
}