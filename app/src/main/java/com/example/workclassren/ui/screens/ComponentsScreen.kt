package com.example.workclassren.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
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
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
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
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Slider
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowHeightSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import com.example.workclassren.R
import com.example.workclassren.data.model.MenuModel
import com.example.workclassren.data.model.PostCardModel
import com.example.workclassren.ui.components.PostCardCompactComponent
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.composed
import androidx.compose.ui.input.pointer.pointerInput


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentsScreen (navController: NavHostController){

    val menuOptions= arrayOf(
        MenuModel(1,"Buttons", "buttons", Icons.Filled.AddCircle), //arreglo de un elemento basado en un modelo
        MenuModel(2,"Floating Buttons", "floating_buttons", Icons.Filled.Add),
        MenuModel(3,"Progress", "progress", Icons.Filled.Check),
        MenuModel(4,"Chips", "chips", Icons.Filled.Email),
        MenuModel(5,"Sliders", "sliders", Icons.Filled.ShoppingCart),
        MenuModel(6,"Switches", "switches", Icons.Filled.Warning),
        MenuModel(7,"Badges", "badges", Icons.Filled.Menu),
        MenuModel(8,"Snack Bars", "snack_bars", Icons.Filled.Create),
        MenuModel(9,"Alert Dialog", "alert_dialog", Icons.Filled.Notifications),
        MenuModel(10,"Bars", "bars", Icons.Filled.CheckCircle),
        MenuModel(11,"Input Fields", "input_fields", Icons.Filled.Favorite),
        MenuModel(12,"Date Pickers", "date_pickers", Icons.Filled.Call),
        MenuModel(13,"Pull To Refresh", "pull_to_refresh", Icons.Filled.DateRange),
        MenuModel(14,"Bottom Sheets", "bottom_sheets", Icons.Filled.Home),
        MenuModel(15,"Segmented Buttons", "segmented_buttons", Icons.Filled.Person)




    )

    var option by rememberSaveable { mutableStateOf("buttons") } //guardar la opcion que elige
    var drawerState = rememberDrawerState(initialValue =DrawerValue.Closed )
    var scope = rememberCoroutineScope()

    ModalNavigationDrawer (
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Menú", modifier = Modifier.padding(16.dp))
                HorizontalDivider()
                LazyColumn {
                    items(menuOptions) { item ->
                        NavigationDrawerItem(
                            icon = {
                                Icon(item.icon, contentDescription = "Icon")
                            },
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
            }
        }
    ) {

        Column{
            when(option){
                "buttons" -> {
                    Buttons()
                }
                "floating_buttons" -> {
                    FloatingButtons()
                }
                "progress" -> {
                    Progress()
                }
                "chips" ->{
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
                "snack_bars" -> {
                    SnackBars()
                }
                "alert_dialogs" -> {
                    AlertDialogs()
                }
                "bars" -> {
                    Bars()
                }
                "input_fields" -> {
                    InputFields()

                }
                "date_pickers" -> {
                    DatePickers(onDateSelected = { selectedDate ->

                        println("Fecha seleccionada: $selectedDate")
                    },
                        onDismiss = {

                            println("DatePicker cerrado")
                        })

                }
                "segmented_buttons" -> {
                    SegmentedButtons()
                }
                "bottom_sheets"->{
                    BottomSheet()
                }
               "pull_to_refresh"-> {
                    PullToRefresh()
                }
            }
        }

    }
}



@Composable
fun PullToRefresh() {
    var isRefreshing by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    var offsetY by remember { mutableStateOf(0f) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .pullToRefresh(
                isRefreshing = isRefreshing,
                onRefresh = {
                    coroutineScope.launch {
                        isRefreshing = true
                        delay(2000) // Simula la carga
                        isRefreshing = false
                        offsetY = 0f
                    }
                },
                onDragChange = { delta ->
                    if (!isRefreshing) {
                        offsetY += delta
                        if (offsetY > 120f) offsetY = 120f // Limite de arrastre
                    }
                }
            ),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top
        ) {
            if (isRefreshing || offsetY > 30f) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }

            repeat(20) {
                Text(
                    text = "Elemento $it",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .background(Color.White)
                )
            }
        }
    }
}

/**
 * Extensión para detectar el gesto de "pull-to-refresh"
 */
fun Modifier.pullToRefresh(
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
    onDragChange: (Float) -> Unit
) = composed {
    pointerInput(isRefreshing) {
        detectVerticalDragGestures(
            onVerticalDrag = { _, dragAmount ->
                onDragChange(dragAmount)
            },
            onDragEnd = {
                if (!isRefreshing) {
                    onRefresh()
                }
            }
        )
    }
}



/*
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PullToRefresh() {
    val refreshState = rememberPullToRefreshState()
    var isRefreshing by remember { mutableStateOf(false) }
    val items = remember { (0..40).toList() }
    val coroutineScope= rememberCoroutineScope()
    PullToRefreshBox(
        state=refreshState,
        isRefreshing=isRefreshing,
        onRefresh={
            coroutineScope.launch {
                isRefreshing= true
                delay(3000)
                isRefreshing=false
            }
        }
    ){
        LazyColumn {
            items(items){
                ListItem(
                    headlineContent = {
                        Text("Item $it")
                    }
                )
            }
        }
    }

}
*/

@Preview(showBackground = true)
@Composable
fun Buttons(){
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ){

        Button(onClick = {}) {
            Text("Filled")
        }
        FilledTonalButton(onClick = {}) {
            Text("Tonal")
        }
        OutlinedButton(onClick = {}) {
            Text("Outlined")
        }
        ElevatedButton(onClick = {}) {
            Text("Elevated")
        }
        TextButton(onClick = {}) {
            Text("Text")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FloatingButtons() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        FloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add,
                contentDescription = "Add Button")
        }
        SmallFloatingActionButton(onClick = {}) { //este boton es mas pequeño que el primero
            Icon(Icons.Filled.Add,
                contentDescription = "Add Button")
        }
        LargeFloatingActionButton(onClick = {}) { //este es mas grande
            Icon(Icons.Filled.Add,
                contentDescription = "Add Button")
        }
        ExtendedFloatingActionButton(onClick = {}) { //rectangulo mas grande
            Icon(Icons.Filled.Add,
                contentDescription = "Add Button")
            Text("Button")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun Progress() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
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
@Preview(showBackground = true) //sirve para presentar informacion
@Composable
fun Chips() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        AssistChip(
            onClick = {},
            label= { Text("Assist Chip")},
            leadingIcon = {
                Icon(Icons.Filled.AccountBox,
                    contentDescription = "Assist Chip",
                    modifier = Modifier
                        .size(AssistChipDefaults.IconSize))
            }
        )
        var selected by remember { mutableStateOf(false) }
        FilterChip(
            selected =selected ,
            onClick = {selected= !selected },
            label = {Text("Filter Chip")},
            leadingIcon =if (selected){
                {
                    Icon(Icons.Filled.AccountBox,
                        contentDescription = "Assist Chip",
                        modifier = Modifier
                            .size(AssistChipDefaults.IconSize)
                    )
                }
            } else {
                null
            }
        )
        InputChipExample("Dismiss",{})
    }
}

@Composable
fun InputChipExample(
    text: String,
    onDismiss:() -> Unit
){
    var enabled by remember { mutableStateOf(true) }
    if (!enabled) return

    InputChip(
        label= { Text(text)},
        selected = enabled,
        onClick = {
            onDismiss()
            enabled = !enabled
        },
        avatar= {
            Icon(
                Icons.Filled.Person,
                contentDescription = "Icon Person",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        },
        trailingIcon ={
            Icon(
                Icons.Filled.Close,
                contentDescription = "Close Person",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        }
    )
}
@Preview(showBackground = true)
@Composable
fun Sliders() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        var SliderPosition by remember { mutableStateOf(50f) }
        Slider(
            value = SliderPosition,
            onValueChange = {SliderPosition= it },
            steps = 10,
            valueRange = 0f..100f
        )
        Text (
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            text = SliderPosition.toString()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Switches() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        var checked by remember { mutableStateOf(true) }
        Switch(
            checked = checked,
            onCheckedChange = { checked = it }
        )

        var checked2 by remember { mutableStateOf(true) }
        Switch(
            checked = checked2,
            onCheckedChange = { checked2 = it },
            thumbContent = if (checked2){
                {
                    Icon (
                        Icons.Filled.Check,
                        contentDescription = "Icon Check",
                        Modifier.size(InputChipDefaults.AvatarSize)
                    )
                }
            } else {
                null
            }
        )
        var checked3 by remember { mutableStateOf(true) }
        Checkbox(
            checked = checked3,
            onCheckedChange = {checked3= it}
        )
    }
}


@Composable
fun Badges() { //iconos de mensajes sin leer o notificaciones
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    )
    {
        var itemCount by remember { mutableStateOf(0) }
        BadgedBox(
            badge = {
                if (itemCount > 0){
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
                contentDescription = "Shopping cart icon"
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
fun SnackBars() { //Barra de notificacion cuando hacemos una accion
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        val snackState = remember { SnackbarHostState() } //guarda el estado de si se esta mostrando o no
        val snackScope = rememberCoroutineScope() //controla cuanto tiempo se queda en pantalla

        SnackbarHost(hostState = snackState)

        fun launchSnackBar (){
            snackScope.launch { snackState.showSnackbar("The message has been sent") }
        }

        Button(::launchSnackBar) {
            Text("Send message")
        }
    }
}

@Composable
fun AlertDialogs() { //Lanza un mensaje y al mismo tiempo nos pide una confirmacion y no desaparece  hasta elegir la accion
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        var showAlertDialog by remember { mutableStateOf(false) }
        var selectedOption by remember { mutableStateOf("") }

        if (showAlertDialog){
            AlertDialog(
                icon= { Icon (Icons.Filled.Warning, contentDescription = "Warning Icon")},
                title = {Text ("Confirm Deletion")},
                text = {Text("Are you sure you want to delete this file?")},
                onDismissRequest ={},
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

        Button (onClick = { showAlertDialog=true}) {
            Text("Delete file")
        }
        Text (selectedOption)

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Bars(){
    Column(
        modifier = Modifier
            .fillMaxSize()
    ){
        LargeTopAppBar(
            colors= TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.secondary
            ),
            title = {Text("Screen Title")},
            actions = {
                IconButton(onClick ={} ) {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = "Icon")
                }
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Settings, contentDescription = "Icon 2" )
                }
            }
        )
        val arrayPost= arrayOf(
            PostCardModel(1,"Title 1", "Text 1", R.drawable.matrix),
            PostCardModel(2,"Title 2", "Text 2", R.drawable.matrix),
            PostCardModel(3,"Title 3", "Text 3", R.drawable.matrix),
            PostCardModel(4,"Title 4", "Text 4", R.drawable.matrix),
            PostCardModel(5,"Title 5", "Text 5", R.drawable.matrix),
            PostCardModel(6,"Title 6", "Text 6", R.drawable.matrix),
            PostCardModel(7,"Title 7", "Text 7", R.drawable.matrix),
            PostCardModel(8,"Title 8", "Text 8", R.drawable.matrix),
            PostCardModel(9,"Title 9", "Text 9", R.drawable.matrix)

        )
        LazyHorizontalGrid(
            rows = GridCells.Adaptive(minSize = 100.dp),
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ){
            items(arrayPost){ item ->
                PostCardCompactComponent(item.id,item.title,item.text,item.image) //parametros agregados en el PostComponent
            }
        }

        Column (
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
        ){
            Adaptive()

        }



        BottomAppBar (
            containerColor = Color.Gray,
            contentColor = Color.Black
        ){
            IconButton(
                modifier = Modifier.weight(1f),
                onClick = {},

                ) {
                Icon (imageVector = Icons.Filled.Person, contentDescription = "")
            }
            IconButton(
                modifier = Modifier.weight(1f),
                onClick = {},

                ) {
                Icon (imageVector = Icons.Filled.Search, contentDescription = "")
            }
            IconButton(
                modifier = Modifier.weight(1f),
                onClick = {},

                ) {
                Icon (imageVector = Icons.Filled.AccountBox, contentDescription = "")
            }
            IconButton(
                modifier = Modifier.weight(1f),
                onClick = {},

                ) {
                Icon (imageVector = Icons.Filled.Close, contentDescription = "")
            }
            IconButton(
                modifier = Modifier.weight(1f),
                onClick = {},

                ) {
                Icon (imageVector = Icons.Filled.Build, contentDescription = "")
            }
        }

    }
}

@Composable
fun Adaptive (){
    var windowSize = currentWindowAdaptiveInfo().windowSizeClass
    var height = currentWindowAdaptiveInfo().windowSizeClass.windowHeightSizeClass
    var width = currentWindowAdaptiveInfo().windowSizeClass.windowWidthSizeClass
    //Compact width < 600 dp Phone Portrait (parado)
    //Medium width >= 600 dp < 840 dp Tablet Portrait (parada)
    //Expanded width >= 840 dp Tablet Landscape (acostada)

    //Compact height < 480 dp Phone Landscape (acostado)
    //Medium height >= 480 dp < 900 dp Tablet Landscape o Phone Portrait (acostado)
    //Expanded height >= 900 dp Tablet Portrait (parada)

    val arrayPost= arrayOf(
        PostCardModel(1,"Title 1", "Text 1", R.drawable.matrix),
        PostCardModel(2,"Title 2", "Text 2", R.drawable.matrix),
        PostCardModel(3,"Title 3", "Text 3", R.drawable.matrix),
        PostCardModel(4,"Title 4", "Text 4", R.drawable.matrix),
        PostCardModel(5,"Title 5", "Text 5", R.drawable.matrix),
        PostCardModel(6,"Title 6", "Text 6", R.drawable.matrix),
        PostCardModel(7,"Title 7", "Text 7", R.drawable.matrix),
        PostCardModel(8,"Title 8", "Text 8", R.drawable.matrix),
        PostCardModel(9,"Title 9", "Text 9", R.drawable.matrix)

    )
    if (width == WindowWidthSizeClass.COMPACT){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ){
            items(arrayPost){ item ->
                PostCardCompactComponent(item.id,item.title,item.text,item.image) //parametros agregados en el PostComponent
                //ejemplo de pull to refresh

            }
        }
    } else if (height == WindowHeightSizeClass.COMPACT){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ){
            items(arrayPost){ item ->
                PostCardCompactComponent(item.id,item.title,item.text,item.image) //parametros agregados en el PostComponent
            }
        }
    }
}




@Composable
fun InputFields (){
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = {text=it},
        label = {Text("Label")}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickers( // modal
    onDateSelected: (Long?) -> Unit,
    onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState()

    DatePickerDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = {
                onDateSelected(datePickerState.selectedDateMillis)
                onDismiss()
            }) {
                Text("OK")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    ) {
        DatePicker(state = datePickerState)
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SegmentedButtons(modifier: Modifier = Modifier) {
    var selectedIndex by remember { mutableIntStateOf(0) }
    val options = listOf("Day", "Month", "Week")

    SingleChoiceSegmentedButtonRow {
        options.forEachIndexed { index, label ->
            SegmentedButton(
                shape = SegmentedButtonDefaults.itemShape(
                    index = index,
                    count = options.size
                ),
                onClick = { selectedIndex = index },
                selected = index == selectedIndex,
                label = { Text(label) }
            )
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet() {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Show bottom sheet") },
                icon = { Icon(Icons.Filled.Add, contentDescription = "") },
                onClick = {
                    showBottomSheet = true
                }
            )
        }
    ) { contentPadding ->
        Box(modifier = Modifier.padding(contentPadding)) {
            Text("Pantalla principal")
        }
    }


    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            sheetState = sheetState
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Este es un BottomSheet")
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    scope.launch { sheetState.hide() }.invokeOnCompletion {
                        if (!sheetState.isVisible) {
                            showBottomSheet = false
                        }
                    }
                }) {
                    Text("Cerrar")
                }
            }
        }
    }
}


