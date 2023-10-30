package com.example.petprojectlistfilms.domain.filmUseCase

import com.example.petprojectlistfilms.domain.Repository

class DeleteFilmFromFavoritesUseCase(private val repository: Repository) {
    fun deleteFilm(idFilm: Int, idUser: Int){
        repository.deleteFilm(idFilm, idUser)
    }
}