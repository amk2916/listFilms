package com.example.petprojectlistfilms.domain.model

/**
 * Пользователь
 */
data class User(
    val id: Long,
    val login: String,
    val password: String,
    val token: String
/*    val firstName: String?,
    val secondName: String?,
    val male: Gender,
    val age: Int,
    val icon: String*/
)