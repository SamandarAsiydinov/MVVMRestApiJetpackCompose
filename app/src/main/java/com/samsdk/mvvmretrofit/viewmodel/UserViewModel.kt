package com.samsdk.mvvmretrofit.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.samsdk.mvvmretrofit.model.UserResponse
import com.samsdk.mvvmretrofit.repository.UserRepository
import com.samsdk.mvvmretrofit.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    var isLoading = mutableStateOf(false)
    private var _getUserData: MutableLiveData<List<UserResponse>> = MutableLiveData()
    var getUserData: LiveData<List<UserResponse>> = _getUserData

    suspend fun getUserData(): Resource<List<UserResponse>> {
        val result = userRepository.getUserResponse()
        if (result is Resource.Success) {
            isLoading.value = true
            _getUserData.value = result.data!!
        }
        return result
    }
}