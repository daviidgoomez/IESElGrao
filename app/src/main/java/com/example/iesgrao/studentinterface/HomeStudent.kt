@file:Suppress("PreviewAnnotationInFunctionWithParameters")

package com.example.iesgrao.studentinterface

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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
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
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.iesgrao.R
import com.example.iesgrao.mainscreens.HomeStudentContent
import com.example.iesgrao.mainscreens.NavigationActivity

import com.example.iesgrao.ui.theme.IESGRAOTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun MyNavigationDrawer(navController: NavHostController, onCloseDrawer: () -> Unit) {
    val tabs = listOf(
        "Información del curso",
        "Profesores",
        "Asignaturas",
        "Satisfacción",
        "Erasmus +"
    )

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Spacer(modifier = Modifier.height(16.dp))


        tabs.forEach { tab ->
            DrawerItem(
                text = tab,
                onClick = {
                    onCloseDrawer()

                    when (tab) {
                        "Información del curso" -> navController.navigate(NavigationActivity.CourseInfo.route)
                        "Profesores" -> navController.navigate(NavigationActivity.StudentTeachers.route)
                        "Asignaturas" -> navController.navigate(NavigationActivity.StudentSubjects.route)
                        "Satisfacción" -> navController.navigate(NavigationActivity.StudentSatisfaction.route)
                        "Erasmus +" -> navController.navigate(NavigationActivity.ErasmusPlus.route)
                    }
                }
            )
        }

        Divider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.padding(top = 16.dp, bottom = 8.dp))

        Text(
            text = "© 2024 IES El Grao",
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun DrawerItem(text: String, onClick: () -> Unit) {
    Text(
        text = text,
        color = MaterialTheme.colorScheme.onBackground,
        modifier = Modifier
            .clickable { onClick() }
            .padding(16.dp)
    )
}


@SuppressLint("CoroutineCreationDuringComposition")
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppStructure(navController: NavHostController) {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var currentScreen by rememberSaveable { mutableStateOf(HomeStudentContent.Home) }
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                MyNavigationDrawer(navController = navController) { scope.launch { drawerState.close() } }
            }
        },
        gesturesEnabled = true
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { MyTopAppBar(onClickDrawer = { scope.launch { drawerState.open() } }) },
            content = { innerPadding ->
                when (currentScreen) {
                    HomeStudentContent.Home -> MyContentMain(innerPadding)
                    HomeStudentContent.Profile -> MyContentProfile(innerPadding)
                }
            },
            bottomBar = { MyBottomNavigation(currentScreen = currentScreen, onTabSelected = { screen -> currentScreen = screen }) },
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
fun MyContentMain(innerPadding: PaddingValues) {
    val contextForToast = LocalContext.current.applicationContext
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        val welcome = createRef()

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
                text = "¡Bienvenido Alumno!",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    Toast.makeText(
                        contextForToast,
                        "Aún no se ha publicado tu horario, vuelve pronto !",
                        Toast.LENGTH_LONG
                    ).show()
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(onClickDrawer: () -> Unit) {
    var isAppClosed by remember {
        mutableStateOf(false)
    }
    val uriHandler = LocalUriHandler.current

    TopAppBar(
        title = {
            Text(
                "Menú del Alumno",
                fontWeight = FontWeight.Bold
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.LightGray),
        navigationIcon = {
            IconButton(onClick = { onClickDrawer() }) {
                Icon(Icons.Filled.Menu, contentDescription = null)
            }
        },
        actions = {
            IconButton(onClick = {
               uriHandler.openUri(uri = "https://portal.edu.gva.es/ieselgrao/?page_id=1393")
            }) {
                Column {
                    Icon(Icons.Filled.Info, contentDescription = null)
                    Text(
                        text = "Info",
                        modifier = Modifier.padding(start = 2.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sp
                    )
                }
            }

            Spacer(modifier = Modifier.size(27.dp))
        }
    )
}
@Composable
fun MyBottomNavigation(currentScreen: HomeStudentContent, onTabSelected: (HomeStudentContent) -> Unit) {
    var index by rememberSaveable { mutableIntStateOf(1) }
    val uriHandler = LocalUriHandler.current

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
                    contentDescription = "Enviar un correo",
                    modifier = Modifier
                        .clickable {uriHandler.openUri(
                            uri = "https://accounts.google.com/v3/signin/identifier?continue=https%3A%2F%2Ftakeout.google.com%2F%3Fhl%3Des&followup=https%3A%2F%2Ftakeout.google.com%2F%3Fhl%3Des&hl=es&ifkv=ASKXGp36HjKbV_EBFgga_lSQXUQLZrmGEFlX5pOidd8CmME8D8TGFG1uUug1e99sq9i_xQnMUV9fZw&osid=1&passive=1209600&flowName=GlifWebSignIn&flowEntry=ServiceLogin&dsh=S-334634640%3A1706123367719211&theme=glif")}

                )
            },
            label = { Text("Enviar Correo") }
        )
        NavigationBarItem(
            selected = currentScreen == HomeStudentContent.Home,
            onClick = { onTabSelected(HomeStudentContent.Home) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Página principal"
                )
            },
            label = { Text("Home") }
        )
        NavigationBarItem(
            selected = currentScreen == HomeStudentContent.Profile,
            onClick = { onTabSelected(HomeStudentContent.Profile) },
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
        modifier = modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp)),
        color = Color.Black
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun HomeStudentPreview() {
    IESGRAOTheme {
        ConstraintLayout {
            val navController = rememberNavController()
            AppStructure(navController = navController)
        }
    }
}


