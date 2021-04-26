package com.picpay.desafio.android.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.picpay.desafio.android.data.ResultState
import com.picpay.desafio.android.data.repository.UserRepository

import java.lang.IllegalArgumentException

class UserViewModel (private val repository: UserRepository) : ViewModel() {
    val users: LiveData<ResultState> = liveData{
        runCatching{
            repository.getUsers()
        }.onSuccess {
            if(it.isEmpty()){
                emit(ResultState.Error)

            }else{
                emit(ResultState.Success(it))
            }
        }.onFailure {
            emit(ResultState.Error)
        }
    }

    class ViewModelFactory(private val repository: UserRepository):
            ViewModelProvider.Factory{
                override fun <T : ViewModel?> create(modelClass: Class<T>):T{
                    if(modelClass.isAssignableFrom(UserViewModel::class.java)){
                        return UserViewModel(repository) as T
                    }
                    throw IllegalArgumentException("Unknown Viewmodel Class")
                }
            }
}