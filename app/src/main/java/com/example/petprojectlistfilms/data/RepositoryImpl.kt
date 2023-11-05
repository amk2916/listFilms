package com.example.petprojectlistfilms.data

import com.example.petprojectlistfilms.domain.Repository
import com.example.petprojectlistfilms.domain.model.Film
import com.example.petprojectlistfilms.domain.model.User

object RepositoryImpl : Repository {
    override fun addFilmFromFavorites(film: Film, idUser: Int) {
        TODO("Not yet implemented")
    }

    override fun deleteFilm(idFilm: Int, idUser: Int) {
        TODO("Not yet implemented")
    }

    override fun editFilm(film: Film) {
        TODO("Not yet implemented")
    }

    override fun getFilms(): List<Film> {
        TODO("Not yet implemented")
    }

    override fun getFilmsInternet(): List<Film> {
        TODO("Not yet implemented")
    }

    override fun getFilm(idFilm: Int): Film {
        TODO("Not yet implemented")
    }

    override fun authorization(login: String, password: String): Int {
        TODO("Not yet implemented")
    }

    override fun check(login: String, password: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun deleteUser(idUser: Int) {
        TODO("Not yet implemented")
    }

    override fun editUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun addUser(user: User) {
        TODO("Not yet implemented")
    }
}