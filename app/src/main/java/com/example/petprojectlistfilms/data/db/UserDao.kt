package com.example.petprojectlistfilms.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.petprojectlistfilms.domain.model.User


@Dao
interface UserDao {



    // регистрация
    @Insert
    fun addUser(user: UserDbModel):Long



    // получение токена после регистрации
    @Query("Select token from users where id  =:userId")
    fun getToken(userId: Int) : String




    //Проверка существования пользователя
    @Query("Select * from users where token = :token ")
    fun getUserByToken(token: String):UserDbModel?



    //удаление пользователя
    @Query("Delete from users where token = :token")
    fun deleteUser(token: String)

}