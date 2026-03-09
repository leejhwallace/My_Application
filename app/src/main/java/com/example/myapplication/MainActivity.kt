package com.example.myapplication


import RandomPageName
import android.R.id.text1
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    StringView(viewModel = viewModel())
                }
            }
        }
    }
}

@Composable
fun ToDoList() {

    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            "TO-DO LIST",
            fontWeight = FontWeight.Bold
        )
        Row {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    "Important task #1",
                    color = Color.Red,
                    textDecoration = TextDecoration.Underline
                )
                Text (
                    "Shut up",
                    fontSize = 10.sp
                )
                Text(
                    "Important task #2",
                    color = Color.Red,
                    textDecoration = TextDecoration.Underline
                )
                Text (
                    "Shut up",
                    fontSize = 10.sp
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    "Unimportant task #1",
                    color = Color.Green,
                    textDecoration = TextDecoration.Underline
                )
                Text (
                    "Shut up",
                    fontSize = 10.sp
                )
                Text(
                    "Unimportant task #2",
                    color = Color.Green,
                    textDecoration = TextDecoration.Underline
                )
                Text (
                    "Shut up",
                    fontSize = 10.sp
                )
            }
        }
    }
}

@Composable
fun login() {
    Column (modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center){
        var text by remember {mutableStateOf( "")}
        Text(text)
        var username by remember { mutableStateOf("")}
        var pw by remember { mutableStateOf("")}

        OutlinedTextField (
            value = username,
            onValueChange = { username = it},
            placeholder = { username = "Username*"},
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField (
            value = pw,
            onValueChange = { pw = it},
            placeholder = { pw = "Password*"},
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            text = "Welcome, $username"
            username = ""
            pw = ""
        },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("Log In")
        }
    }
}

@Composable
fun rwg() {
    var word by remember {mutableStateOf( "")}
    var desc by remember {mutableStateOf( "")}
    var wcolor by remember {mutableStateOf(Color.Black)}
    val wordList = mutableListOf("concorde", "chicken", "laptop")
    val descList = mutableListOf("plane", "food", "technology")
    val colorList = mutableListOf(Color.Blue, Color.Green, Color.Gray)
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "RWG",
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            fontSize = 45.sp
        )
        Text(
            text = "To get started, click the button"
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            word,
            color = wcolor
        )
        Text(desc)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedButton(onClick = {
            val rdm = (0..2).random()
            word = wordList[rdm]
            desc = descList[rdm]
            wcolor = colorList[rdm]
        },
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Roll a new word")
        }
    }
}

@Composable
fun StartView1() {
    val navController1 = rememberNavController()
    NavHost(
        navController = navController1,
        startDestination = "StartView1",
        modifier = Modifier.fillMaxSize()
    ) {
        composable("StartView1") {
            Column {
                Text(text = "StartView1")

                Button(
                    onClick = {
                        navController1.navigate("RandomPageView")
                    }
                ) {
                    Text("Go next page")
                }
            }
        }

        composable("RandomPageView") {
            RandomPageName(navHostController = navController1)
        }
    }
}
@Composable
fun StartView() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "StartView",
        modifier = Modifier.fillMaxSize(),
    ) {
        composable("StartView") {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Start Screen",
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { navController.navigate("FirstView") }
                ) {
                    Text(text = "Go to First Page")
                }
            }
        }
        composable("FirstView") {
            FirstView(navController = navController)
        }
        composable("AnotherView") {
            AnotherView(navController = navController)
        }
    }
}
@Composable

fun FirstView(navController: NavHostController) {
    var selectedTab by remember { mutableStateOf("Tab1") }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "First Screen",
            fontSize = 24.sp
        )
        Scaffold (

            bottomBar = {

                BottomAppBar {
                    Button(onClick = { selectedTab = "Tab1" }) { Text("1st View") }
                    Button(onClick = { selectedTab = "Tab2" }) { Text("2nd View") }
                }
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                if (selectedTab == "Tab1") {
                    Text(text = "First Page", fontSize = 24.sp)
                    Spacer(modifier = Modifier.height(16.dp))
                } else {
                    Text(text = "Second Page", fontSize = 24.sp)
                    Button(onClick = { navController.navigate("AnotherView") }) {
                        Text("Go to Another Page")
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnotherView(navController: NavHostController) {
    Scaffold (
        topBar = {
            TopAppBar (
                title = { Text("Another Page") },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(imageVector = Icons.AutoMirrored.Default.ArrowBack, contentDescription = "")
                    }
                })
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(text = "Another Page")
        }
    }
}

class MainViewModel: ViewModel(){
    private val _text1 = MutableStateFlow("Chicken")
    val text1: StateFlow<String> = _text1

    private val _text2 = MutableStateFlow("Nugget")
    val text2: StateFlow<String> = _text2

}

@Composable
fun StringView(viewModel: MainViewModel) {
    val navController2 = rememberNavController()
    NavHost(
        navController = navController2,
        startDestination = "StringView",
        modifier = Modifier.fillMaxSize()
    ) {
        composable("StringView") {
            val text1 by viewModel.text1.collectAsState()
            val text2 by viewModel.text2.collectAsState()
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = text1)
                Text(text = text2)
                Button(
                    onClick = {
                        navController2.navigate("String1View")
                    }
                ) {
                    Text("Go next page")
                }
            }
        }
        composable("String1View") {
            String1View(navController = navController2, viewModel = viewModel)
        }
    }
}

@Composable
fun String1View(navController: NavHostController, viewModel: MainViewModel) {
    val text1 by viewModel.text1.collectAsState()
    val text2 by viewModel.text2.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = text2)
        Text(text = text1)
        Button(onClick = { navController.popBackStack() }) {
            Text("Previous page")
        }

    }
}
@Composable
fun app1() {
    Column {
        Text("Hello World")
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    MyApplicationTheme {
        StringView(viewModel = viewModel())
    }
}