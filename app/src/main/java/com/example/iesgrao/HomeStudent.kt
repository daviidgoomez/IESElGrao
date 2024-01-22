package com.example.iesgrao

import android.annotation.SuppressLint
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import com.example.iesgrao.ui.theme.IESGRAOTheme
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun MyNavigationDrawer(onCloseDrawer:() -> Unit) {
    Column(modifier = Modifier.padding(8.dp)) {
        repeat(5) {
            Text(
                text = "Opción ${it + 1}",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .clickable { onCloseDrawer() }
            )
        }
    }
}


@SuppressLint("CoroutineCreationDuringComposition")
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppStructure() {
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                MyNavigationDrawer() { scope.launch { drawerState.close() } }
            }
        },
        gesturesEnabled = true
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { MyTopAppBar(onClickDrawer = { scope.launch { drawerState.open() } }) },
            content = { innerPadding ->
                MyContent(innerPadding)
            },
            bottomBar = { MyBottomNavigation() },
            floatingActionButtonPosition = FabPosition.End,
            floatingActionButton = { LogoutFAB(navController = navController) }
        )
    }
}


    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun LogoutFAB(navController: NavHostController) {
        Row {
            FloatingActionButton(
                onClick = {
                    navController.navigate(NavigationActivity.LoginScreenMain.route)
                },
                modifier = Modifier
                    .padding(16.dp)
                    .size(56.dp),
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(Icons.Default.ExitToApp, contentDescription = "Cerrar Sesión")
            }
        }
    }


    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun MyContent(innerPadding: PaddingValues) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            val (welcome, date) = createRefs()


            Column(
                modifier = Modifier
                    .padding(13.dp)
                    .constrainAs(welcome) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                Spacer(modifier = Modifier.padding(20.dp))
                Text(
                    text = "La aplicación recibirá una actualización el 18/02/2024",
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    // .clickable {

                    // },
                    color = Color.White
                )
                Spacer(modifier = Modifier.padding(5.dp))
                RealTimeDate(modifier = Modifier.align(Alignment.CenterHorizontally))
                Spacer(modifier = Modifier.padding(44.dp))


                // Imagen del instituto
                Image(
                    painter = painterResource(id = R.drawable.grao2),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .clip(shape = RoundedCornerShape(8.dp))
                        .background(MaterialTheme.colorScheme.background)
                )
                Spacer(modifier = Modifier.height(16.dp))


                Text(
                    text = "¡Bienvenido alumno!",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        //  Toast.makeText(
                        //  LocalContext.current,
                        //   "Todavía no hay un horario disponible, vuelve pronto!",
                        //  Toast.LENGTH_SHORT
                        //  ).show()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    Text(text = "Ver Horario", fontWeight = FontWeight.Bold)
                }

            }

        }
    }

    @Composable
    fun showHorarioNotification() {
        Toast.makeText(
            LocalContext.current,
            "Todavía no hay un horario disponible, vuelve pronto!",
            Toast.LENGTH_SHORT
        ).show()
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MyTopAppBar(onClickDrawer:() -> Unit) {
        TopAppBar(
            title = {
                Text(
                    "Menú del Alumno",
                    fontWeight = FontWeight.Bold
                )
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.LightGray),
            navigationIcon = {
                IconButton(onClick = {onClickDrawer() }) {
                    Icon(Icons.Filled.Menu, contentDescription = null) }
            },
            actions = {
                IconButton(onClick = { }) {
                    Icon(Icons.Filled.Info, contentDescription = null)
                    Text(
                        text = "Info",
                        modifier = Modifier.padding(top = 29.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sp
                    )
                }
                Spacer(modifier = Modifier.size(6.dp))
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Close, contentDescription = null)
                    Text(
                        text = "Salir",
                        modifier = Modifier.padding(top = 29.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sp
                    )
                }
                Spacer(modifier = Modifier.size(6.dp))
            }
        )
    }

    @Composable
    fun MyBottomNavigation() {
        var index by rememberSaveable { mutableIntStateOf(0) }
        NavigationBar(
            containerColor = Color.LightGray,
            contentColor = Color.White
        ) {
            NavigationBarItem(
                selected = index == 0,
                onClick = { index = 0 },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Horario del Alumno"
                    )
                },
                label = { Text("Enviar Correo") }
            )
            NavigationBarItem(
                selected = index == 1,
                onClick = { index = 1 },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Página principal"
                    )
                },
                label = { Text("Home") }
            )
            NavigationBarItem(
                selected = index == 2,
                onClick = { index = 2 },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Perfil del Alumno"
                    )
                },
                label = { Text("Mi Perfil") }
            )
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun RealTimeDate(modifier: Modifier) {
        var currentDateTime by remember { mutableStateOf(LocalDateTime.now()) }

        LaunchedEffect(key1 = currentDateTime) {
            while (true) {
                delay(1000) // Actualiza cada segundo
                currentDateTime = LocalDateTime.now()
            }
        }

        val formattedDate =
            currentDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))

        Text(
            text = "Fecha y Hora: $formattedDate",
            modifier = Modifier
                .padding(8.dp)
                // .clickable { /* Acción al hacer clic */ }
                .background(MaterialTheme.colorScheme.secondary)
                .clip(RoundedCornerShape(8.dp)),
            color = Color.White
        )
    }


    @RequiresApi(Build.VERSION_CODES.O)
    @Preview(showBackground = true)
    @Composable
    fun HomeStudentPreview() {
        IESGRAOTheme {
            ConstraintLayout {
                AppStructure()
            }

        }
    }

