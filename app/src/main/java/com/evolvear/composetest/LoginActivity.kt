package com.evolvear.composetest

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.evolvear.composetest.ui.theme.ComposeTestTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                Surface(color = MaterialTheme.colors.background) {
                    LoginScreen(name = "Aqeel")
                }
            }
        }
    }

    private fun loggedIn(userName : String, userPassword : String){
        if(userName == "Aqeel" && userPassword == "12345"){
            Toast.makeText(this,"Login Successfully !",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this,"wrong credentials !",Toast.LENGTH_LONG).show()
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ComposeTestTheme {
            LoginScreen("Android")
        }
    }

    @Composable
    fun LoginScreen(name: String) {

        val userName = remember {
            mutableStateOf("")
        }
        val userPassword = remember {
            mutableStateOf("")
        }

        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Text(text = "Hello $name!", color = Color.Red, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Monospace, fontSize = 25.sp)
            Text(text = "Welcome", color = Color.Red, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Monospace, fontSize = 22.sp)
            Text(text = "Back!", color = Color.Red, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Monospace, fontSize = 22.sp)
            
            OutlinedTextField(
                value = userName.value,
                onValueChange ={ userName.value = it },
                leadingIcon = {
                    Icon(Icons.Default.Person, contentDescription = "usrName")
                },
                label = {
                        Text(text = "User Name")
                },
                placeholder = {
                    Text(text = "Enter UserName")
                },
                modifier = Modifier.fillMaxWidth(),
            )
            OutlinedTextField(
                value = userPassword.value,
                onValueChange ={ userPassword.value = it },
                leadingIcon = {
                    Icon(Icons.Default.Info, contentDescription = "password")
                },
                label = {
                    Text(text = "User Password")
                },
                placeholder = {
                    Text(text = "Enter Password")
                },
                modifier = Modifier.fillMaxWidth(),

            )
            
            OutlinedButton(
                onClick = { loggedIn(userName.value, userPassword.value) },
                modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
            ) {
                Text(text = "Login")
                
            }
        }
    }
}