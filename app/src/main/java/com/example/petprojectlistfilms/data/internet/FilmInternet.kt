package com.example.petprojectlistfilms.data.internet

data class MovieData(
    val fees: Map<String, Fee>,
/*    val status: String?,
    val externalId: ExternalId
    val id: Long,
    val type : String,
    val name: String,
    val description: String*/
)

data class Fee(
    val value: Long,
    val currency: String
)

data class ExternalId(
    val kpHD: String,
    val imdb: String,
    val tmdb: Int
)