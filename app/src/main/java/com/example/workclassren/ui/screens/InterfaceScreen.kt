package com.example.workclassren.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
        TopBar()
        Divider(color = colorResource(R.color.gris_claro), thickness = 1.dp)
        ProfilePicture()
        Divider(
            modifier = Modifier.fillMaxWidth(0.9f),
            color = colorResource(R.color.gris_claro),
            thickness = 1.dp
        )
        RecentActivity()

    }

}

//@Preview (showBackground = true)
@Composable
fun TopBar() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Black)
            .height(90.dp)

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Icon(
                modifier = Modifier.size(30.dp),
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
            modifier = Modifier.fillMaxWidth().padding(top=7.dp),
            horizontalArrangement = Arrangement.Center

        ) {
            Text(
                text = "Profile",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(color = colorResource(R.color.gris_claro))
                    .padding(horizontal = 24.dp)
                    .height(20.dp)

            )
            Text(
                text = "Diary",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(color = colorResource(R.color.gris_fuerte))
                    .padding(horizontal = 24.dp)
                    .height(20.dp)

            )
            Text(
                text = "Lists",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(color = colorResource(R.color.gris_fuerte))
                    .padding(horizontal = 24.dp)
                    .height(20.dp)

            )
            Text(
                text = "Watchlist",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(color = colorResource(R.color.gris_fuerte))
                    .padding(horizontal = 24.dp)
                    .height(20.dp)

            )
        }

    }
}

//@Preview(showBackground = true)
@Composable
fun ProfilePicture() {
    Box(
        modifier = Modifier
            .background(color = colorResource(R.color.gris_fuerte))
            .fillMaxWidth()
            .height(180.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.prof_pic),
            contentDescription = "Profile Picture",
            contentScale = ContentScale.Crop, // Recorta la imagen para que llene el espacio
            modifier = Modifier
                .size(80.dp) // Tamaño del círculo
                .clip(CircleShape) // Recorte circular
                .border(2.dp, Color.Gray, CircleShape) // Borde opcional
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RecentActivity(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(color = colorResource(R.color.gris_fuerte))
    ){
        Text(
            modifier = Modifier.padding(start=10.dp, top=15.dp),
            text = "RECENT ACTIVITY",
            color = Color.Gray
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(R.color.gris_fuerte)),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column (
                modifier = Modifier
                    .background(color = colorResource(R.color.gris_fuerte))
            ){
                Image(
                    painter = painterResource(R.drawable.movie1),
                    contentDescription = "MovieCartel1"
                )


            }
            Column (
                modifier = Modifier
                    .background(color = colorResource(R.color.gris_fuerte))
            ){
                Image(
                    painter = painterResource(R.drawable.movie2),
                    contentDescription = "MovieCartel1"
                )


            }
            Column (
                modifier = Modifier
                    .background(color = colorResource(R.color.gris_fuerte))
            ){
                Image(
                    painter = painterResource(R.drawable.movie3),
                    contentDescription = "MovieCartel1"
                )


            }
            Column (
                modifier = Modifier
                    .background(color = colorResource(R.color.gris_fuerte))
            ){
                Image(
                    painter = painterResource(R.drawable.movie4),
                    contentDescription = "MovieCartel1"
                )


            }

        }

    }
}


