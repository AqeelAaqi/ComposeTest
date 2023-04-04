package com.evolvear.composetest.Retrofit.util

import com.evolvear.composetest.Retrofit.Post

sealed class ApiState{

    class Success (val data: List<Post>) : ApiState()
    class Failure (val msg: Throwable) : ApiState()
    object Loading : ApiState()
    object Empty : ApiState()

}