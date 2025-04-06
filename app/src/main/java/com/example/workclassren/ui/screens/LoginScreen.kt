package com.example.workclassren.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun LoginScreen (navController: NavController) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
    ){
        LoginForm()

    }
}

@Preview(showBackground = true)
@Composable
fun LoginForm (){
    Card(
        modifier = Modifier
            .padding(40.dp, 0.dp)
    ) {
        Column (
            modifier = Modifier
                .padding(20.dp)
        ){
            var user by remember {  mutableStateOf("")}
                var password by remember {  mutableStateOf("")}

            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 10.dp),
                model = "https://cdn.kinocheck.com/i/j7qxa1uc8s.jpg",
                contentDescription = "Imagen URL",
                contentScale = ContentScale.Fit
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = user,
                maxLines = 1,
                onValueChange = {user = it},
                label = { Text("Username")}

            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = password,
                maxLines = 1,
                onValueChange = {password = it},
                label = { Text("Password")}

            )

            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 10.dp),
                shape = CutCornerShape(4.dp),
                onClick = {}
            ) {
                Text("Login")
            }

            FilledTonalButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 10.dp),
                shape = CutCornerShape(4.dp),
                onClick = {}
            ) {
                Text("Create Account")
            }
            }
        }
    }
