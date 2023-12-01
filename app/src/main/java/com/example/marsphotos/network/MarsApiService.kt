package com.example.marsphotos.network

import retrofit2.http.GET
import retrofit2.Retrofit
import com.example.marsphotos.network.MarsApi
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaType
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType

private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"



private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()


object MarsApi {
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}

interface MarsApiService {
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}



