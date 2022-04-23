package com.samsdk.mvvmretrofit.model

data class UserResponse(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)