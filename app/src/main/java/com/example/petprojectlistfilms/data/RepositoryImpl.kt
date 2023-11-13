package com.example.petprojectlistfilms.data

import com.example.petprojectlistfilms.data.db.UserDao
import com.example.petprojectlistfilms.data.db.UserDbModel
import com.example.petprojectlistfilms.domain.Mapper
import com.example.petprojectlistfilms.domain.Repository
import com.example.petprojectlistfilms.domain.model.Film
import com.example.petprojectlistfilms.domain.model.User

class RepositoryImpl(
    private val userDao: UserDao,
    private val mapper: Mapper
) : Repository {
    override fun addFilmFromFavorites(film: Film, idUser: Int) {
        TODO("Not yet implemented")
    }

    override fun deleteFilm(idFilm: Int, idUser: Int) {
        TODO("Not yet implemented")
    }

    override fun editFilm(film: Film) {
        TODO("Not yet implemented")
    }

    override fun getFilms(): List<Film> {
        TODO("Not yet implemented")
    }

    override fun getFilmsInternet(): List<Film> {
        TODO("Not yet implemented")
    }

    override fun getFilm(idFilm: Int): Film {
        TODO("Not yet implemented")
    }


    // логика связанная с ЛК пользователя
    override fun getUser(login: String, password: String): User {
        return mapper.userDbToModel(userDao.getUser(login, password))
    }

    override fun getUser(token: String): User {
        return mapper.userDbToModel(userDao.getUserByToken(token))
    }

    override fun deleteUser(token: String) {
        userDao.deleteUser(token)
    }

    override fun editUser(user: User) {
        //val userDbModel = mapper.userModelToDb(user)
        userDao.updateUser(mapper.userModelToDb(user))//(userDbModel.password, userDbModel.token, userDbModel.id)
    }

    override fun addUser(user: User) : String {
        val generateId = userDao.addUser(mapper.userModelToDb(user))
        val newToken = "${(generateId+33)*user.login.length}${user.password.uppercase()}" +
                       "-${(generateId+34)*user.password.length}${user.login.uppercase()}"

        val newUser = user.copy(id= generateId, token = newToken)
        editUser(newUser)
        return newToken
    }
}