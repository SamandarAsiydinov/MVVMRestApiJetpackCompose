package com.samsdk.mvvmretrofit.network

import com.samsdk.mvvmretrofit.model.UserResponse
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface ApiInterface {

    @GET("todos")
    suspend fun getUserData(): List<UserResponse>
}