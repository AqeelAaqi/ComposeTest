package com.evolvear.composetest.Retrofit.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.evolvear.composetest.Retrofit.MainRepository
import com.evolvear.composetest.Retrofit.util.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val mainRepository: MainRepository) : ViewModel() {

    val response : MutableState<ApiState> = mutableStateOf(ApiState.Empty)

    init {
        getPosts()
    }

    fun getPosts() = viewModelScope.launch {
        mainRepository.getPosts()
            .onStart {
            response.value = ApiState.Loading
        }
            .catch {
            response.value = ApiState.Failure(it)
        }
            .collect{
            response.value = ApiState.Success(it)
        }
    }
}