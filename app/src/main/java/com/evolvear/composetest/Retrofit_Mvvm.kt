package com.evolvear.composetest

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.evolvear.composetest.ui.theme.ComposeTestTheme

class Retrofit_Mvvm : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            ComposeTestTheme() {

            }
        }
    }
}