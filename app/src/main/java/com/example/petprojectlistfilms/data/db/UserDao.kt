package com.example.petprojectlistfilms.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.petprojectlistfilms.domain.model.User


@Dao
interface UserDao {

    // регистрация
    @Insert
    fun addUser(user: UserDbModel):Long


    // получение токена после регистрации
    @Query("Select * from users where login = :login and password = :password")
    fun getUser(login: String, password: String) : UserDbModel?


    //Проверка существования пользователя (для сохранения токена и входа через шаред преференс)
    @Query("Select * from users where token = :token ")
    fun getUserByToken(token: String):UserDbModel?


    //удаление пользователя
    @Query("Delete from users where token = :token")
    fun deleteUser(token: String)


    //обновление данных
   // @Query("update users set password = :password, token = :token where id = :id")//todo(разобраться как работает анотация)
    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateUser(user: UserDbModel)//(password: String, token: String, id: Long)
}