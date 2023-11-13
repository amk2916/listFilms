package com.example.petprojectlistfilms.domain

import com.example.petprojectlistfilms.domain.model.Film
import com.example.petprojectlistfilms.domain.model.User

interface Repository {
    fun addFilmFromFavorites(film: Film, idUser: Int)
    fun deleteFilm(idFilm: Int, idUser: Int)
    fun editFilm(film:Film)
    fun getFilms():List<Film>
    fun getFilmsInternet():List<Film>
    fun  getFilm(idFilm: Int): Film


    //функциональность связанная с пользователем
    fun getUser(login: String, password: String): User

    fun getUser(token: String): User

    fun deleteUser(token: String)
    fun editUser(user: User)
    fun addUser(user:User) : String

}