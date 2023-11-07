package com.example.petprojectlistfilms.domain.model

/**
 * фильм
 * id - id фильма
 * nameFilm - Имя фильма
 * description - описание
 * image - ссылка на картинку
 * comment - комментарий
 */
data class Film(
    val id: Int,
    val nameFilm: String,
    val description: String,
    val image: String,
    val comment: String?
)
