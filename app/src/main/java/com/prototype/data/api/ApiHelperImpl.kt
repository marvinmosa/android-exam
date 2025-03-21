package com.prototype.data.api

import com.prototype.data.model.Person
import retrofit2.Response


class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {

    override suspend fun getUsers(): Response<List<Person>> = apiService.getUsers()
}