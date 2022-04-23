package com.samsdk.mvvmretrofit.repository

import com.samsdk.mvvmretrofit.model.UserResponse
import com.samsdk.mvvmretrofit.network.ApiInterface
import com.samsdk.mvvmretrofit.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class UserRepository @Inject constructor(
    private val apiInterface: ApiInterface
) {
    suspend fun getUserResponse(): Resource<List<UserResponse>> {
        val response = try {
            apiInterface.getUserData()
        } catch (e: Exception) {
            return Resource.Error(e.message.toString())
        }
        return Resource.Success(response)
    }
}