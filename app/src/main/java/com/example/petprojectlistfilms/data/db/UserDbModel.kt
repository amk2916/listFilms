package com.example.petprojectlistfilms.data.db

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(
    tableName = "users",
    indices = [Index("token", unique = true), Index("login", unique = true)]
)
data class UserDbModel(
    @PrimaryKey(autoGenerate = true) val id: Long = -1,
    val login: String,
    val password: String,
    val token: String
)
