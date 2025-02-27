package com.example.workclassren.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.workclassren.R


@Composable
fun InterfaceScreen(navController: NavHostController) {
    Column (
        modifier = Modifier
            .fillMaxSize()

    ){
        Spacer(
            modifier = Modifier.padding(bottom=25.dp)
        )
        TopBar()
    }

}

@Preview (showBackground = true)
@Composable
fun TopBar() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Black)
            .height(150.dp)

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Icon(
                modifier = Modifier.size(25.dp),
                imageVector = Icons.Default.Settings,
                contentDescription = "Configuracion",
                tint = Color.White
            )

            Text(

                text = "renace_r",
                fontSize = 20.sp,
                color = Color.White
            )
            Row(
                verticalAlignment = Alignment.CenterVertically

            ) {
                Text("·", color = Color.White, fontSize = 35.sp)
                Text("·", color = Color.White, fontSize = 35.sp)
                Text("·", color = Color.White, fontSize = 35.sp)
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),

            //  verticalAlignment = Alignment.CenterVertically
            horizontalArrangement = Arrangement.Center

        ) {
             Text(
                modifier = Modifier
                    .background(color = colorResource(R.color.gris_claro))
                    .padding(end = 12.dp, start = 12.dp)
                    .height(25.dp)
                    .clip(RoundedCornerShape(5.dp)),

                text = "Profile",
                fontWeight = FontWeight.Bold,

                color = Color.White,
                        textAlign = Alignment.CenterVertically,
            )
            Text(
                modifier = Modifier
                    .background(color = Color.Black)
                    .padding(end = 12.dp, start = 12.dp),
                text = "Diary",
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                modifier = Modifier
                    .background(color = Color.Black)
                    .padding(end = 12.dp, start = 12.dp),
                text = "Lists",
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                modifier = Modifier
                    .background(color = Color.Black)
                    .padding(end = 12.dp, start = 12.dp),
                text = "Watchlist",
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

    }
}

