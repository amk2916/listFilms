package com.example.petprojectlistfilms.domain.filmUseCase

import com.example.petprojectlistfilms.domain.Repository
import com.example.petprojectlistfilms.domain.model.Film

class AddFilmFromFavoritesUseCase(private val repository: Repository) {
    fun addFilmFromFavorites(film: Film, idUser: Int){
        repository.addFilmFromFavorites(film, idUser)
    }
}