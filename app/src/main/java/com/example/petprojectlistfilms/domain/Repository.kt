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
    fun authorization(login: String, password: String): Int
    fun check(login: String, password: String): Boolean
    fun deleteUser(idUser: Int)
    fun editUser(user: User)
    fun addUser(user:User)

}