package com.prototype.data.api

import com.prototype.data.model.Person
import retrofit2.Response

interface ApiHelper {

    suspend fun getUsers(): Response<List<Person>>
}