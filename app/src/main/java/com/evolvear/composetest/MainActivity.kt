package com.evolvear.composetest

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.evolvear.composetest.ui.theme.ComposeTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
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
                            actions = {
                                IconButton(onClick = { }) {
                                    Icon(
                                        Icons.Filled.Notifications ,
                                        contentDescription = "notifications"
                                    )
                                }
                                IconButton(onClick = { }) {
                                    Icon(
                                        Icons.Filled.Search ,
                                        contentDescription = "search"
                                    )
                                }
                            }
                        )
                    },
                    floatingActionButton = {
                        FloatingActionButton(onClick = {}) {
                            IconButton(onClick = { }) {
                                Icon(
                                    Icons.Filled.Add ,
                                    contentDescription = "add"
                                )
                            }
                        }
                    },
                    floatingActionButtonPosition = FabPosition.End,
                ) {
                    Greeting(name = "Android")
                }
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    Greeting("Android")
//                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column() {
        Text(text = "Hello $name!", color = Color.Red)
//        Text(text = "Aqeel $name!", color = Color.Red, style = TextStyle(fontWeight = FontWeight.ExtraBold) , softWrap = true)
    }
}

@Preview(showBackground = true, name = "light mode")
@Preview(showBackground = true,  name = "dark mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview() {
    ComposeTestTheme {
        Greeting("Android")
    }
}