package com.example.workclassren.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.workclassren.ui.components.TopBarComponent
import com.example.workclassren.data.model.AccountModel
import com.example.workclassren.data.viewmodel.AccountViewModel
import com.example.workclassren.ui.components.TopBarComponent

@Composable
fun ManageAccountScreen(navController: NavController, viewModel: AccountViewModel = viewModel())
{
    val account = remember { mutableStateOf(AccountModel()) }
    val context = LocalContext.current
    Column(modifier = Modifier
        .background(MaterialTheme.colorScheme.background)
        .padding(10.dp)
        .fillMaxSize()
    ) {


        TopBarComponent("Add account", navController, "manage_account_screen")
        OutlinedTextField(modifier = Modifier
            .fillMaxWidth(),
            value = account.value.name,
            maxLines = 1,
            label = {"Account name" },
            onValueChange = {account.value = account.value.copy(name = it)}
        )
        OutlinedTextField(modifier = Modifier
            .fillMaxWidth(),
            value = account.value.username,
            maxLines = 1,
            label = {"Account username" },
            onValueChange = {account.value = account.value.copy(username = it)}
        )
        OutlinedTextField(modifier = Modifier
            .fillMaxWidth(),
            value = account.value.password,
            maxLines = 1,
            label = {"Account password" },
            onValueChange = {account.value = account.value.copy(password = it)}
        )
        OutlinedTextField(modifier = Modifier
            .fillMaxWidth(),
            value = account.value.description,
            maxLines = 1,
            label = {"Account description" },
            onValueChange = {account.value = account.value.copy(description = it)}
        )
        FilledTonalButton(modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 10.dp),
            onClick =  {
                //..tarea on click, delete
            }
        ){
            Text("Save account")
        }
    }
}