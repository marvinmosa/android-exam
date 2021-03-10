package com.prototype.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prototype.data.model.User
import com.prototype.data.repository.MainRepository
import com.prototype.ui.base.BaseViewModel
import com.prototype.utils.NetworkHelper
import com.prototype.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainViewModel(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper

) : BaseViewModel() {

    private val user = MutableLiveData<Result<List<User>>>()
    val users: LiveData<Result<List<User>>>
        get() = user

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            user.postValue(Result.loading(null))
//            if (networkHelper.isNetworkConnected()) {
                withContext(Dispatchers.IO) {
                    mainRepository.getUsers().let {
                        if (it.isSuccessful) {
                            user.postValue(Result.success(it.body()))
                        } else user.postValue(Result.error(null, it.errorBody().toString()))
                    }
                }
//            } else user.postValue(Result.error(null, "No internet connection"))
        }
    }
}