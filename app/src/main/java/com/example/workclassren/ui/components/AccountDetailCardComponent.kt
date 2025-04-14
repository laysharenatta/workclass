package com.example.workclassren.ui.components

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.workclassren.R
import com.example.workclassren.data.model.AccountEntity

@Composable
fun AccountDetailCardComponent(
    id: Int,
    name: String,
    username: String,
    password: String,
    imageURL: String,
    description: String,
    onSaveClick: () -> Unit,
    onDeleteClick: (AccountEntity) -> Unit,
    navController: NavController,
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AsyncImage(
            model = imageURL,
            contentDescription = "Account Logo",
            contentScale = ContentScale.Fit,
            error = painterResource(R.drawable.matrix),
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {
                onSaveClick()
                Toast.makeText(context, "Guardado como favorito", Toast.LENGTH_SHORT).show()
            }) {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "Save as Favorite",
                )
            }

            IconButton(onClick = {
                navController.navigate("manage_account_screen?id=$id")
            }) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit Account"
                )
            }

            IconButton(onClick = {
                val accountEntity = AccountEntity(
                    id = id,
                    name = name,
                    username = username,
                    password = password,
                    imageURL = imageURL,
                    description = description
                )
                onDeleteClick(accountEntity)
            }) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = "Delete account",
                )
            }
        }
    }

    Spacer(modifier = Modifier.height(16.dp))

    InfoRow(title = "Account", value = name)
    InfoRow(title = "Username", value = username)
    InfoRow(title = "Password", value = password, showIcon = true)
    InfoRow(title = "Description", value = description)
}

@Composable
fun InfoRow(title: String, value: String, showIcon: Boolean = false) {
    val showPassword = remember { mutableStateOf(false) }
    val isPasswordField = title.lowercase() == "password"

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$title:",
            modifier = Modifier.weight(1f),
            fontWeight = FontWeight.Bold
        )

        Text(
            text = if (isPasswordField && !showPassword.value) "••••••" else value,
            modifier = Modifier.weight(2f)
        )

        if (isPasswordField && showIcon) {
            IconButton(onClick = { showPassword.value = !showPassword.value }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = if (showPassword.value) "Ocultar" else "Mostrar"
                )
            }
        }
    }
}
