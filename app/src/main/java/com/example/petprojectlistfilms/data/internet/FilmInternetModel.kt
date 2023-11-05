package com.example.petprojectlistfilms.data.internet

//todo(доработать модель приходящую из интернета, нужна картинка и в последствии трейлер, пока хватит так)
data class FilmInternetModel (
    val id: Int,
    val type: String ="",
    val name: String = "",
    val description : String = ""
)