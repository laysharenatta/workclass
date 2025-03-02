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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.List
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
import kotlin.math.round


@Composable
fun InterfaceScreen(navController: NavHostController) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())

    ){
        TopBar()
        Divider(color = colorResource(R.color.gris_claro), thickness = 1.dp)
        ProfilePicture()
        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = colorResource(R.color.gris_claro),
            thickness = 1.dp
        )
        RecentActivity() //ya tiene un divider abajo
        MidBars()
        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = colorResource(R.color.gris_claro),
            thickness = 1.dp
        )
        RemoAds()
        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = colorResource(R.color.gris_claro),
            thickness = 1.dp
        )
        ListsMovies()

    }

}

//@Preview(showBackground = true)
@Composable
fun ListsMovies(){
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .background(color= colorResource(R.color.gris_fuerte))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom =15.dp, top=15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Films", color = Color.LightGray,
                fontSize = 27.sp)
            Row() {
                Text(text = "9/9 this year", color = colorResource(R.color.gris_claro),
                    fontSize = 27.sp)
                    Icon(
                        modifier = Modifier.size(34.dp),
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "Configuracion",
                        tint = Color.DarkGray
                    )
            }
        }
        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = colorResource(R.color.gris_claro),
            thickness = 1.dp
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom =15.dp, top=15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Diary",color = Color.LightGray,
                fontSize = 27.sp)
            Row() {
                Text(text = "9/9 this year", color = colorResource(R.color.gris_claro),
                    fontSize = 27.sp)
                Icon(
                    modifier = Modifier.size(34.dp),
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Configuracion",
                    tint = Color.DarkGray
                )
            }
        }
        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = colorResource(R.color.gris_claro),
            thickness = 1.dp
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom =15.dp, top=15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Reviews", color = Color.LightGray,
                fontSize = 27.sp)
            Row() {
                Text(text = "9", color = colorResource(R.color.gris_claro),
                    fontSize = 27.sp)
                Icon(
                    modifier = Modifier.size(34.dp),
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Configuracion",
                    tint = Color.DarkGray
                )
            }
        }
        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = colorResource(R.color.gris_claro),
            thickness = 1.dp
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom =15.dp, top=15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Lists", color = Color.LightGray,
                fontSize = 27.sp)
            Row() {
                Text(text = "0", color = colorResource(R.color.gris_claro),
                    fontSize = 27.sp)
                Icon(
                    modifier = Modifier.size(34.dp),
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Configuracion",
                    tint = Color.DarkGray
                )
            }
        }
        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = colorResource(R.color.gris_claro),
            thickness = 1.dp
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom =15.dp, top=15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Watchlist",color = Color.LightGray,
                fontSize = 27.sp)
            Row() {
                Text(text = "0", color =colorResource(R.color.gris_claro),
                    fontSize = 27.sp)
                Icon(
                    modifier = Modifier.size(34.dp),
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Configuracion",
                    tint = Color.DarkGray
                )
            }
        }
        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = colorResource(R.color.gris_claro),
            thickness = 1.dp
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom =15.dp, top=15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Likes", color = Color.LightGray,
                fontSize = 27.sp)
            Row() {
                Text(text = "0", color =  colorResource(R.color.gris_claro),
                    fontSize = 27.sp)
                Icon(
                    modifier = Modifier.size(34.dp),
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Configuracion",
                    tint = Color.DarkGray
                )
            }
        }
        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = colorResource(R.color.gris_claro),
            thickness = 1.dp
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom =15.dp, top=15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Tags", color = Color.LightGray,
                fontSize = 27.sp)
            Row() {
                Text(text = "0", color = colorResource(R.color.gris_claro),
                    fontSize = 27.sp)
                Icon(
                    modifier = Modifier.size(34.dp),
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Configuracion",
                    tint = Color.DarkGray
                )
            }
        }
        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = colorResource(R.color.gris_claro),
            thickness = 1.dp
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom =15.dp, top=15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Following", color = Color.LightGray,
                fontSize = 27.sp)
            Row() {
                Text(text = "1", color = colorResource(R.color.gris_claro),
                    fontSize = 27.sp)
                Icon(
                    modifier = Modifier.size(34.dp),
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Configuracion",
                    tint = Color.DarkGray
                )
            }
        }
        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = colorResource(R.color.gris_claro),
            thickness = 1.dp
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom =15.dp, top=15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Followers",color = Color.LightGray,
                fontSize = 27.sp)
            Row() {
                Text(text = "1", color = colorResource(R.color.gris_claro),
                    fontSize = 27.sp)
                Icon(
                    modifier = Modifier.size(34.dp),
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Configuracion",
                    tint = Color.DarkGray
                )
            }
        }
        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = colorResource(R.color.gris_claro),
            thickness = 1.dp
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom =15.dp, top=15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Stats", color = Color.LightGray,
                fontSize = 27.sp)
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Upgrade to", color = colorResource(R.color.gris_claro),
                    fontSize = 27.sp)
                Text(text= " PRO ", color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier=Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .background(color= colorResource(R.color.naranja) ))
            }
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun RemoAds(){
    Column(
        modifier = Modifier
            .background(color = colorResource(R.color.gris_fuerte))
            .fillMaxWidth()
            .padding(bottom = 18.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Image(
            painter = painterResource(R.drawable.anuncioequis),
            contentDescription = "Anuncio Removible",
            modifier  = Modifier
                .size(400.dp)
                .padding(bottom = 10.dp),
            contentScale = ContentScale.Fit
        )
        Text(text="REMOVE ADS", color = colorResource(R.color.gris_claro),
            fontSize = 16.sp)
    }

}


//@Preview(showBackground = true)
@Composable
fun MidBars(){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(R.color.gris_fuerte))
            .height(80.dp)
            .padding(top = 18.dp, bottom = 18.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            modifier = Modifier
                .padding(start = 13.dp),
            text = "★",
            color = Color.Green
        )
        Row(
            modifier = Modifier
                .width(260.dp)
                .background(color = colorResource(R.color.gris_fuerte))
                .height(100.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween


        ) {

            Spacer(
                Modifier.background(color = colorResource(R.color.gris_claro)).width(25.dp)
                    .height(1.dp)
            )
            Spacer(
                Modifier.background(color = colorResource(R.color.gris_claro)).width(25.dp)
                    .height(1.dp)
            )
            Spacer(
                Modifier.background(color = colorResource(R.color.gris_claro)).width(25.dp)
                    .height(1.dp)
            )
            Spacer(
                Modifier.background(color = colorResource(R.color.gris_claro)).width(25.dp)
                    .height(15.dp)
            )
            Spacer(
                Modifier.background(color = colorResource(R.color.gris_claro)).width(25.dp)
                    .height(1.dp)
            )
            Spacer(
                Modifier.background(color = colorResource(R.color.gris_claro)).width(25.dp)
                    .height(1.dp)
            )
            Spacer(
                Modifier.background(color = colorResource(R.color.gris_claro)).width(25.dp)
                    .height(1.dp)
            )
            Spacer(
                Modifier.background(color = colorResource(R.color.gris_claro)).width(25.dp)
                    .height(40.dp)
            )
            Spacer(
                Modifier.background(color = colorResource(R.color.gris_claro)).width(25.dp)
                    .height(27.dp)
            )
            Spacer(
                Modifier.background(color = colorResource(R.color.gris_claro)).width(25.dp)
                    .height(40.dp)
            )
        }
        Text(
            modifier = Modifier
                .padding(end = 13.dp),
            text = "★★★★★",
            color = Color.Green
        )

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
                modifier = Modifier.size(35.dp),
                imageVector = Icons.Default.Settings,
                contentDescription = "Configuracion",
                tint = Color.White
            )

            Text(

                text = "renace_r",
                fontSize = 23.sp,
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
                fontSize = 18.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(color = colorResource(R.color.gris_claro))
                    .padding(horizontal = 24.dp)
                    .height(25.dp)

            )
            Text(
                text = "Diary",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(color = colorResource(R.color.gris_fuerte))
                    .padding(horizontal = 24.dp)
                    .height(25.dp)

            )
            Text(
                text = "Lists",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(color = colorResource(R.color.gris_fuerte))
                    .padding(horizontal = 24.dp)
                    .height(25.dp)

            )
            Text(
                text = "Watchlist",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(color = colorResource(R.color.gris_fuerte))
                    .padding(horizontal = 24.dp)
                    .height(25.dp)

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
            .height(160.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.prof_pic),
            contentDescription = "Profile Picture",
            contentScale = ContentScale.Crop, // Recorta la imagen para que llene el espacio
            modifier = Modifier
                .size(100.dp) // Tamaño del círculo
                .clip(CircleShape) // Recorte circular
                .border(2.dp, Color.Gray, CircleShape) // Borde opcional
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun RecentActivity(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            //.height(270.dp)
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
                .background(color = colorResource(R.color.gris_fuerte))
                .padding(top=7.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Column (
                modifier = Modifier
                    .background(color = colorResource(R.color.gris_fuerte)),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(
                    painter = painterResource(R.drawable.movie1),
                    contentDescription = "MovieCartel1",
                    modifier = Modifier
                        .width(110.dp)
                        .height(150.dp)
                        .clip(RoundedCornerShape(5.dp)),
                    contentScale = ContentScale.Crop
                )
                Text(
                    "★★★★½",
                    color = colorResource(R.color.gris_claro)
                )
            }
            Column (
                modifier = Modifier
                    .background(color = colorResource(R.color.gris_fuerte)),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(
                    painter = painterResource(R.drawable.movie2),
                    contentDescription = "MovieCartel2",
                    modifier = Modifier
                        .width(110.dp)
                        .height(150.dp)
                        .clip(RoundedCornerShape(5.dp)),
                    contentScale = ContentScale.Crop
                )
                Text(
                    "★★★★★",
                    color = colorResource(R.color.gris_claro)
                )
            }
            Column (
                modifier = Modifier
                    .background(color = colorResource(R.color.gris_fuerte)),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(
                    painter = painterResource(R.drawable.movie3),
                    contentDescription = "MovieCartel3",
                    modifier = Modifier
                        .width(110.dp)
                        .height(150.dp)
                        .clip(RoundedCornerShape(5.dp)),
                    contentScale = ContentScale.Crop
                )
                Text(
                    "★★★★½",
                    color = colorResource(R.color.gris_claro)
                )
            }
            Column (
                modifier = Modifier
                    .background(color = colorResource(R.color.gris_fuerte)),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(
                    painter = painterResource(R.drawable.movie4),
                    contentDescription = "MovieCartel4",
                    modifier = Modifier
                        .width(110.dp)
                        .height(150.dp)
                        .clip(RoundedCornerShape(5.dp)),
                    contentScale = ContentScale.Crop
                )
                Text(
                    "★★★★★",
                    color = colorResource(R.color.gris_claro)
                )
            }

        }
        Divider(
            modifier = Modifier.fillMaxWidth().padding(top=12.dp),
            color = colorResource(R.color.gris_claro),
            thickness = 1.dp
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top=7.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically // Alineación vertical centrada
        ) {
            Text(
                text = "More activity",
                color = Color.Gray,
                modifier = Modifier
                    .padding(start = 10.dp), // Ajusta el padding solo en el inicio
                fontSize = 22.sp,
                textAlign = TextAlign.Center // Centra el texto dentro de su espacio
            )
            Icon(
                modifier = Modifier
                    .size(25.dp),
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "arrow",
                tint = Color.Gray
            )
        }
        Divider(
            modifier = Modifier.fillMaxWidth().padding(top=12.dp),
            color = colorResource(R.color.gris_claro),
            thickness = 1.dp
        )



    }

}


