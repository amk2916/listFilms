package com.example.petprojectlistfilms.presentation

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.petprojectlistfilms.data.RepositoryImpl
import com.example.petprojectlistfilms.data.db.AppDataBase
import com.example.petprojectlistfilms.domain.Mapper
import com.example.petprojectlistfilms.domain.model.User
import com.example.petprojectlistfilms.domain.userUseCases.GetUserUseCase
import com.example.petprojectlistfilms.domain.userUseCases.RegistrationUseCase

class RegistrationViewModel(application: Application)
    : AndroidViewModel(application) {

    //-< будем прокидывать через Di
    private val dataBase = AppDataBase.getInstance(application)
    private val mapper = Mapper()
    private val repository = RepositoryImpl(dataBase.userDao(), mapper)
    //->

    private val sharedPreferences = application.getSharedPreferences("ListFilm", Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()






    private val getUserUseCase = GetUserUseCase(repository)
    private val registrationUseCase = RegistrationUseCase(repository)

    var errorAuthorisation = MutableLiveData<Boolean>()

    fun registration(login: String, password: String){
        val newUser = User(login = login, password = password)
        val newUser2 = registrationUseCase.addUser(newUser)
        editor.putString("token", newUser2).commit()
        errorAuthorisation.value = false
    }

    fun authorisation(login: String, password: String){
        val user =  getUserUseCase.check(login, password)
        if(user == Mapper.DEFAULT_USER){
            editor.putString("token", user.token)
            errorAuthorisation.value = false
        }else{
            errorAuthorisation.value = true
        }
    }
    // если тру, то бесшовный вход
    fun checkIsLogin() : Boolean{
        val a = sharedPreferences.getString("token", "") ?:""
        val user = getUserUseCase.check(sharedPreferences.getString("token", "") ?:"")
        return user != Mapper.DEFAULT_USER
    }


}






