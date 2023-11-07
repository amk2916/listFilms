package com.example.petprojectlistfilms.data.internet

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FilmsApi {

    @GET("v1.3/movie/{id}")
    fun getFilmById(
       // @Header("Authorization") token: String,
        @Path("id") id: Int
    ) : Call<FilmInternetModel>


}