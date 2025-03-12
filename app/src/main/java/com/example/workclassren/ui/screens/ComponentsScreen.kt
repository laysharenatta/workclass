package com.example.workclassren.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Slider
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.window.core.layout.WindowHeightSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import com.example.workclassren.R
import com.example.workclassren.data_model.MenuModel
import com.example.workclassren.data_model.PostCardModel
import com.example.workclassren.ui.components.PostCardCompactComponent
import com.example.workclassren.ui.components.PostCardComponent
import com.example.workclassren.ui.components.PostCardComponent
import kotlinx.coroutines.launch


@Composable
fun ComponentsScreen (navController: NavHostController){
    val menuOptions = arrayOf(
        MenuModel(1, "Buttons", "buttons", Icons.Filled.Home),
        MenuModel(2, "FloatingButtons", "floating-buttons", Icons.Filled.Menu),
        MenuModel(3,"Progress","progress", Icons.Filled.Star),
        MenuModel(4,"Chips", "chips", Icons.Filled.ShoppingCart),
        MenuModel(5, "Sliders", "sliders", Icons.Filled.Build),
        MenuModel(6,"Switches", "switches", Icons.Filled.Person),
        MenuModel(7,"Badges", "badges", Icons.Filled.Face),
        MenuModel(8,"SnackBars", "snack-bars", Icons.Filled.AddCircle),
        MenuModel(9,"AlertDialogs", "alert-dialogs", Icons.Filled.Lock),
        MenuModel(10,"Bars", "bars",Icons.Filled.Settings )

    )

    var option by rememberSaveable { mutableStateOf("buttons") }
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed )
    var scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Menu", modifier = Modifier.padding(16.dp))
                HorizontalDivider()
                LazyColumn {
                    items(menuOptions){item ->
                        NavigationDrawerItem(

                            icon = { Icon(item.icon, contentDescription = "")},
                            label = { Text(item.title) },
                            selected = false,
                            onClick = {
                                option = item.option
                                scope.launch {
                                    drawerState.apply {
                                        close()
                                    }
                                }
                            }
                        )
                    }

                }
                /*NavigationDrawerItem(
                    icon = { Icon(Icons.Filled.Check, contentDescription = "")},
                    label = { Text("Floating Buttons")},
                    selected = false,
                    onClick = {
                        option = "floating-buttons"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                NavigationDrawerItem(
                    icon = { Icon(Icons.Filled.Person, contentDescription = "")},
                    label = { Text("Progress")},
                    selected = false,
                    onClick = {
                        option = "progress"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                NavigationDrawerItem(
                    icon = { Icon(Icons.Filled.Add, contentDescription = "")},
                    label = { Text("Chips")},
                    selected = false,
                    onClick = {
                        option = "chips"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                NavigationDrawerItem(
                    icon = { Icon(Icons.Filled.Star, contentDescription = "")},
                    label = { Text("Sliders")},
                    selected = false,
                    onClick = {
                        option = "sliders"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                NavigationDrawerItem(
                    icon = { Icon(Icons.Filled.Build, contentDescription = "")},
                    label = { Text("Switches")},
                    selected = false,
                    onClick = {
                        option = "switches"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                NavigationDrawerItem(
                    icon = { Icon(Icons.Filled.ThumbUp, contentDescription = "")},
                    label = { Text("Badges")},
                    selected = false,
                    onClick = {
                        option = "badges"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                NavigationDrawerItem(
                    icon = { Icon(Icons.Filled.Face, contentDescription = "")},
                    label = { Text("SnackBars")},
                    selected = false,
                    onClick = {
                        option = "snack-bars"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                NavigationDrawerItem(
                    icon = { Icon(Icons.Filled.Menu, contentDescription = "")},
                    label = { Text("AlertDialogs")},
                    selected = false,
                    onClick = {
                        option = "alertdialogs"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )*/
            }
        }
    ) {
        Column {
            when (option){
                "buttons" -> {
                    Buttons()
                }

                "floating-buttons" -> {
                    FloatingButtons()
                }
                "progress" -> {
                    Progress()
                }
                "chips" -> {
                    Chips()
                }
                "sliders" -> {
                    Sliders()
                }
                "switches" -> {
                    Switches()
                }
                "badges" -> {
                    Badges()
                }
                "snack-bars" -> {
                    SnackBars()
                }
                "alertdialogs" -> {
                    AlertDialogs()
                }
                "bars" -> {
                    Bars()
                }
            }

        }

    }

}

//@Preview(showBackground = true)
@Composable
fun Buttons (){
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween

    ){
        Button(onClick = {}) {
            Text("Filled")
        }
        FilledTonalButton (onClick = {}) {
            Text("Tonal")
        }
        OutlinedButton (onClick = {}) {
            Text("Outline")
        }
        ElevatedButton (onClick = {}) {
            Text("Elevated")
        }
        TextButton(onClick = {}) {
            Text("Text")
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun FloatingButtons(){
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ){
        FloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add, contentDescription = "Add Button")
        }
        SmallFloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add, contentDescription = "Add Button")
        }
        LargeFloatingActionButton (onClick = {}) {
            Icon(Icons.Filled.Add, contentDescription = "Add Button")
        }
        ExtendedFloatingActionButton (onClick = {}) {
            Icon(Icons.Filled.Add, contentDescription = "Add Button")
            Text(text = "Button")
        }
    }
}
//@Preview(showBackground = true)
@Composable
fun Progress(){
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ){
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
        )
        CircularProgressIndicator(
            modifier = Modifier
                .width(64.dp)
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun Chips(){
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ){
        AssistChip(
            onClick= {},
            label = {Text("Assist Chip")},
            leadingIcon = {
                Icon(Icons.Filled.AccountBox,
                    contentDescription = "Assist Chip",
                    modifier = Modifier
                        .size(AssistChipDefaults.IconSize)
                )
            }
        )
        var selected by remember { mutableStateOf(false)}
        FilterChip(
            selected = selected,
            onClick = {selected = !selected},
            label = { Text("Filter Chip")},
            leadingIcon = if (selected) {
                {
                    Icon(Icons.Filled.AccountBox,
                        contentDescription = "Assist Chip",
                        modifier = Modifier
                            .size(AssistChipDefaults.IconSize)
                    )
                }
            }else {
                null

            }
        )
        InputChipExamples("Dismiss", {})
    }
}

@Composable
fun InputChipExamples (
    text: String,
    onDismiss: () -> Unit
){
    var enabled by remember { mutableStateOf(true) }
    if(!enabled) return

    InputChip(
        label = {Text (text)},
        selected = enabled,
        onClick = {
            onDismiss()
            enabled = !enabled
        },
        avatar = {
            Icon(
                Icons.Filled.Person,
                contentDescription = "Icon Person",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        },
        trailingIcon = {
            Icon(
                Icons.Filled.Close,
                contentDescription = "Icon Person",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        }
    )
}

//@Preview(showBackground = true)
@Composable
fun Sliders (){
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ) {
        var SliderPosition by remember { mutableStateOf(50f) }
        Slider(
            value = SliderPosition,
            onValueChange = {SliderPosition = it},
            steps = 10,
            valueRange = 0f .. 100f
        )
        Text(
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            text = SliderPosition.toString()

        )
    }
}

//@Preview(showBackground = true)
@Composable
fun Switches (){
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ) {
        var checked by remember { mutableStateOf(true) }
        Switch(
            checked = checked,
            onCheckedChange = {checked = it}
        )
        var checked2 by remember { mutableStateOf(true)}
        Switch(
            checked = checked2,
            onCheckedChange = {checked2 = it},
            thumbContent = if (checked2){
                {
                    Icon(
                        Icons.Filled.Check,
                        contentDescription = "Switch Check",
                        Modifier.size(InputChipDefaults.AvatarSize)
                    )
                }
            }else{
                null
            }
        )
        var checked3 by remember { mutableStateOf(true)}
        Checkbox(
            checked = checked3,
            onCheckedChange = {checked3 = it}
        )

    }
}

@Preview(showBackground = true)
@Composable
fun Badges (){
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ) {
        var itemCount by remember { mutableStateOf(0)}
        BadgedBox(
            badge = {
                if(itemCount > 0){
                    Badge(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ){
                        Text(itemCount.toString())
                    }
                }
            }
        ) {
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "Shoping cart icon"
            )

        }

        Button(
            onClick = {itemCount++}
        ) {
            Text("Add item")
        }
    }
}

@Composable
fun SnackBars(){
    Column (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        val snackState= remember {SnackbarHostState()}
        val snackScope = rememberCoroutineScope ()

        SnackbarHost(hostState = snackState)

        fun launchSnackBar(){
            snackScope.launch { snackState.showSnackbar("The massage has been sent") }
        }

        Button(::launchSnackBar){
            Text("Send message")
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogs(){
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        var showAlertDialog by remember { mutableStateOf(false)}
        var selectedOption by remember { mutableStateOf("") }

        if (showAlertDialog){
            AlertDialog(
                icon = { Icon(Icons.Filled.Warning, contentDescription = "Warning Icon")},
                title = { Text("Confirm Delection")},
                text = { Text("Are you sure you want to delete the file") },
                onDismissRequest = {},
                confirmButton = {
                    TextButton(
                        onClick = {
                            selectedOption = "Confirmed"
                            showAlertDialog = false
                        }
                    ) {
                        Text("Yes")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            selectedOption = "Canceled"
                            showAlertDialog = false
                        }
                    ) {
                        Text("No")
                    }
                }
            )
        }

        Button(onClick = {showAlertDialog= true}){
            Text("Delete file")
        }
        Text(selectedOption)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Bars(){
    Column (modifier = Modifier
        .fillMaxSize()
    ){

        LargeTopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.secondary
            ),
            title = { Text("Screen Title")},
            actions= {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = "Search button")
                }
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Settings, contentDescription = "Settings button")
                }
            }
        )
        /*
        val arrayposts= arrayOf(
            PostCardModel(1, "Title 1", "Text 1", R.drawable.p),
            PostCardModel(2, "Title 2", "Text 2", R.drawable.p),
            PostCardModel(3, "Title 3", "Text 3", R.drawable.p),
            PostCardModel(4, "Title 4", "Text 4", R.drawable.p),
            PostCardModel(5, "Title 5", "Text 5", R.drawable.p),
            PostCardModel(6, "Title 6", "Text 6", R.drawable.p),
            PostCardModel(7, "Title 7", "Text 7", R.drawable.p),
            PostCardModel(8, "Title 8", "Text 8", R.drawable.p),
            PostCardModel(9, "Title 9", "Text 9", R.drawable.p),
        )
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize= 160.dp),
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ){
            items(arrayposts){ item ->
                PostCardComponent(item.id, item.title, item.text, item.image)

            }
        }
        */
        Column (
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
        ) {
            Adaptive()
        }
        BottomAppBar (
            containerColor = Color.DarkGray,
            contentColor= Color.White
        ){
            IconButton(
                modifier = Modifier.weight(1f),
                onClick = {},
            ){
                Icon(imageVector = Icons.Filled.Info, contentDescription = "" )
            }
            IconButton(
                modifier = Modifier.weight(1f),
                onClick = {},
            ){
                Icon(imageVector = Icons.Filled.Face, contentDescription = "" )
            }
            IconButton(
                modifier = Modifier.weight(1f),
                onClick = {},
            ){
                Icon(imageVector = Icons.Filled.Star, contentDescription = "" )
            }
            IconButton(
                modifier = Modifier.weight(1f),
                onClick = {},
            ){
                Icon(imageVector = Icons.Filled.Lock, contentDescription = "" )
            }
            IconButton(
                modifier = Modifier.weight(1f),
                onClick = {},
            ){
                Icon(imageVector = Icons.Filled.Warning, contentDescription = "" )
            }
        }

    }
}

@Composable
fun Adaptive (){
    var windowSize = currentWindowAdaptiveInfo().windowSizeClass
    var height = currentWindowAdaptiveInfo().windowSizeClass.windowHeightSizeClass
    var width = currentWindowAdaptiveInfo().windowSizeClass.windowWidthSizeClass
    // Compact width < 600 dp Phone Portrait
    // Medium Width >= 600 dp < 840 dp Tablet Portrait
    // Expanded Width >= 840 dp Tablet Landscape

    // Compact Height < 480 dp Phone Landscape
    // Medium Height >= 480 dp  < 900 dp Tablet Landscape Phone Portrait
    // Expanded Height >= 900 dp  Tablet Portrait

    val arrayposts= arrayOf(
        PostCardModel(1, "Title 1", "Text 1", R.drawable.matrix),
        PostCardModel(2, "Title 2", "Text 2", R.drawable.matrix),
        PostCardModel(3, "Title 3", "Text 3", R.drawable.matrix),
        PostCardModel(4, "Title 4", "Text 4", R.drawable.matrix),
        PostCardModel(5, "Title 5", "Text 5", R.drawable.matrix),
        PostCardModel(6, "Title 6", "Text 6", R.drawable.matrix),
        PostCardModel(7, "Title 7", "Text 7", R.drawable.matrix),
        PostCardModel(8, "Title 8", "Text 8", R.drawable.matrix),
        PostCardModel(9, "Title 9", "Text 9", R.drawable.matrix),
    )

    if (width == WindowWidthSizeClass.COMPACT){

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()

        ){
            items(arrayposts){ item ->
                PostCardComponent(item.id, item.title, item.text, item.image)

            }
        }


    }else if (height == WindowHeightSizeClass.COMPACT)
    {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()

        ){
            items(arrayposts){ item ->
                PostCardCompactComponent(item.id, item.title, item.text, item.image)

            }
        }
    }

}