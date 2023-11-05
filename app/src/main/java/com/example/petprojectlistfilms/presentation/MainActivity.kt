package com.example.petprojectlistfilms.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.petprojectlistfilms.R
import com.example.petprojectlistfilms.data.internet.FilmInternetModel
import com.example.petprojectlistfilms.data.internet.FilmsApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val baseUrl = "https://api.kinopoisk.dev/"
        val token = "RKEKDA3-6HHMGHS-K8FP2WN-G5TS661"

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor{chain ->
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                     .header("X-API-KEY", token) // Попробуем передать токен с помощью ретрофита в гет запрос
                val request = requestBuilder.build()
                chain.proceed(request)
            }
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(FilmsApi::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            apiService.getFilmById( 652).enqueue(object : Callback<FilmInternetModel>{
                override fun onResponse(call: Call<FilmInternetModel>, response: Response<FilmInternetModel>) {
                    if(response.isSuccessful){
                        val responseData = response.body()//= response.body()?.toString() ?: "нет данных"
                        Log.e("RESPONSE", responseData.toString())
                    }else{
                        Log.e("RESPONSEFail", "FAIL")
                    }
                }

                override fun onFailure(call: Call<FilmInternetModel>, t: Throwable) {
                    Log.e("onFailure", "FAIL")
                }

            })
        }
    }
}