package com.evolvear.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.evolvear.composetest.ui.theme.ComposeTestTheme
import com.evolvear.composetest.utils.dummyData

class RecyclerviewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                window.statusBarColor = MaterialTheme.colors.primaryVariant.toArgb() // status bar
                // A surface container using the 'background' color from the theme
                Surface(color = Color.Companion.Green) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = { Text(text = "JetPack Compose") },
                                navigationIcon = {
                                    IconButton(onClick = { }) {
                                        Icon(
                                            Icons.Filled.Menu ,
                                            contentDescription = "menu"
                                        )
                                    } },
                            )
                        },
                    ) {
                        RecyclerViewData(dummyData())
                    }
                }


            }
        }
    }


}
