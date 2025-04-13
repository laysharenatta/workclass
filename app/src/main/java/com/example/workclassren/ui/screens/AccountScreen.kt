package com.example.workclassren.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.workclassren.data.dataBase.AppDataBase
import com.example.workclassren.data.dataBase.dataBaseProvider
import com.example.workclassren.data.model.AccountModel
import com.example.workclassren.data.model.toAccountEntity
import com.example.workclassren.data.viewmodel.AccountViewModel
import com.example.workclassren.ui.components.AccountCardComponent
import com.example.workclassren.ui.components.AccountDetailCardComponent
import com.example.workclassren.ui.components.TopBarComponent

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountsScreen (
    navController: NavController,
    viewModel: AccountViewModel = viewModel()
) {
    var accounts by remember { mutableStateOf<List<AccountModel>>(emptyList()) }
    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false
    )
    var accountDetail by remember { mutableStateOf<AccountModel?>(null) }
    val db: AppDataBase = dataBaseProvider.getDataBase(LocalContext.current)
    val accountDao = db.accountDao()


    Column {
        TopBarComponent("Accounts", navController, "accounts_screen")

        LaunchedEffect(Unit) {
            viewModel.getAccounts { response ->
                if (response.isSuccessful) {
                    accounts = response.body() ?: emptyList()
                } else {
                    Log.d("debug", "Failed to load data")
                }
            }
        }
        val listState = rememberLazyListState()
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            state = listState
        ) {
            items(accounts) { account ->
                AccountCardComponent (
                    account.id,
                    account.name,
                    account.username,
                    account.imageURL,
                    onButtonClick = {
                        viewModel.getAccount(account.id) { response ->
                            if (response.isSuccessful) {
                                accountDetail = response.body()
                            }
                        }
                        showBottomSheet = true
                    }
                )
            }
        }
        //AccountCardComponent(1,"name", "user@gmail.com", "")
    }
    if (showBottomSheet) {
        ModalBottomSheet(
            modifier = Modifier.fillMaxHeight(),
            onDismissRequest = {
                showBottomSheet = false
            },
            sheetState = sheetState
        ) {
            AccountDetailCardComponent (
                accountDetail?.id ?: 0,
                accountDetail?.name ?: " ",
                accountDetail?.username ?: " ",
                accountDetail?.password ?: " ",
                accountDetail?.imageURL ?: " ",
                accountDetail?.description ?: " ",
                onSaveClick = {
                    CoroutineScope(Dispatchers.IO).launch {
                        try {
                            accountDetail?.let { accountDao.insert(it.toAccountEntity()) }
                            Log.d("debug-db", "Account inserted successfully")
                        } catch (exception: Exception) {
                            Log.d("debug-db", "ERROR: $exception")
                        }
                    }
                }
            )
        }
    }
}