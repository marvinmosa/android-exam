package com.prototype.data.api

import com.prototype.data.model.Person
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): Response<List<Person>>
}