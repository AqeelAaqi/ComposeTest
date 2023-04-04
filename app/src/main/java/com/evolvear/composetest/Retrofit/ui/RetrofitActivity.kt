package com.evolvear.composetest.Retrofit.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.evolvear.composetest.R
import com.evolvear.composetest.RecyclerViewRetrofit
import com.evolvear.composetest.Retrofit.util.ApiState
import com.evolvear.composetest.ui.theme.ComposeTestTheme
import com.evolvear.composetest.utils.DataSource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RetrofitActivity : ComponentActivity() {

    private val mainViewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent { 
            ComposeTestTheme() {
                Surface(color = MaterialTheme.colors.background) {
                    GetDataFromNetwork(mainViewModel)
                }
                
            }
        }
    }

    @Composable
    fun GetDataFromNetwork(viewModel: MainViewModel){
        when(val result = viewModel.response.value){
            is ApiState.Success ->{
                RecyclerViewRetrofit(dataItem = result.data)
            }
            is ApiState.Loading ->{
                CircularProgressIndicator()
            }
            is ApiState.Failure ->{
                Text(text = "${result.msg}")
            }
            is ApiState.Empty ->{

            }
        }
    }
}