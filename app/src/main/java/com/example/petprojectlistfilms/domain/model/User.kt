package com.example.petprojectlistfilms.domain.model

import com.example.petprojectlistfilms.domain.Gender

/**
 * Пользователь
 */
data class User(
    val id: Int,
    val login: String,
    val password: String,
    val firstName: String?,
    val secondName: String?,
    val male: Gender,
    val age: Int,
    val icon: String
)