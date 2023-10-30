package com.example.petprojectlistfilms.domain.model

/**
 * фильм
 */
data class Film(
    val id: Int,
    val nameFilm: String,
    val response: String,
    val image: String,
    val comment: String?
)
