package com.example.petprojectlistfilms.domain

import com.example.petprojectlistfilms.data.db.UserDbModel
import com.example.petprojectlistfilms.domain.model.User

class Mapper {

    fun userModelToDb(user: User):UserDbModel{
        return UserDbModel(
            id = user.id,
            login = user.login,
            password = user.password,
            token = user.token
        )
    }

    fun userDbToModel(dbModel: UserDbModel?) : User{
        return dbModel?.let{
            User(
                id = it.id,
                login = it.login,
                password = it.password,
                token = it.token
            )
        }?: DEFAULT_USER
    }



    companion object{
        val DEFAULT_USER = User(-1,"","","")
    }
}