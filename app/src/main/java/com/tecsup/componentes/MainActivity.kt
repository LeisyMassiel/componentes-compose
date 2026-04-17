package com.tecsup.componentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.*

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*

import androidx.compose.material3.*

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                PantallaPrincipal()
            }
        }
    }
}


@Composable
fun PantallaPrincipal() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        item { MiTopAppBar() }

        item { MiButton() }
        item { MiCard() }
        item { MiCheckbox() }
        item { MiFAB() }
        item { MiIcon() }
        item { MiImage() }

        item { MiRadioButton() }
        item { MiSlider() }
        item { MiSwitch() }
        item { MiTextField() }

        item { MiGrid() }

        item { MiTabRow() }

        item { MiSnackbar() }

        item { MiDialog() }
    }
}

@Composable
fun MiButton() {
    Button(onClick = {}) {
        Text("Button")
    }
}

@Composable
fun MiCard() {
    Card {
        Text("Card", modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun MiCheckbox() {
    var checked by remember { mutableStateOf(false) }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = checked, onCheckedChange = { checked = it })
        Text("Checkbox")
    }
}

@Composable
fun MiFAB() {
    FloatingActionButton(onClick = {}) {
        Icon(Icons.Default.Add, contentDescription = "")
    }
}

@Composable
fun MiIcon() {
    Icon(Icons.Default.Home, contentDescription = "Icono")
}

@Composable
fun MiImage() {
    Image(
        painter = painterResource(id = R.drawable.android),
        contentDescription = "Imagen",
        modifier = Modifier.size(80.dp)
    )
}


@Composable
fun MiRadioButton() {
    var selected by remember { mutableStateOf("A") }

    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(selected = selected == "A", onClick = { selected = "A" })
        Text("A")

        Spacer(modifier = Modifier.width(10.dp))

        RadioButton(selected = selected == "B", onClick = { selected = "B" })
        Text("B")
    }
}

@Composable
fun MiSlider() {
    var value by remember { mutableStateOf(0.5f) }
    Slider(value = value, onValueChange = { value = it })
}

@Composable
fun MiSwitch() {
    var checked by remember { mutableStateOf(false) }
    Switch(checked = checked, onCheckedChange = { checked = it })
}

@Composable
fun MiTextField() {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Texto") }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MiTopAppBar() {
    TopAppBar(
        title = { Text("App") },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(Icons.Default.Menu, contentDescription = "")
            }
        }
    )
}


@Composable
fun MiGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.height(150.dp)
    ) {
        items(2) {
            Text("Item $it", modifier = Modifier.padding(8.dp))
        }
    }
}


@Composable
fun MiTabRow() {
    var selectedTab by remember { mutableStateOf(0) }

    TabRow(selectedTabIndex = selectedTab) {
        Tab(selected = selectedTab == 0, onClick = { selectedTab = 0 }) {
            Text("Tab 1")
        }
        Tab(selected = selectedTab == 1, onClick = { selectedTab = 1 }) {
            Text("Tab 2")
        }
    }
}


@Composable
fun MiSnackbar() {
    Snackbar {
        Text("Mensaje Snackbar")
    }
}


@Composable
fun MiDialog() {
    var show by remember { mutableStateOf(false) }

    Column {
        Button(onClick = { show = true }) {
            Text("Mostrar Dialog")
        }

        if (show) {
            AlertDialog(
                onDismissRequest = { show = false },
                confirmButton = {
                    Button(onClick = { show = false }) {
                        Text("OK")
                    }
                },
                title = { Text("Dialog") },
                text = { Text("Contenido") }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    MaterialTheme {
        PantallaPrincipal()
    }
}