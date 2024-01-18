package com.example.iesgrao

import android.app.DownloadManager
import android.net.http.HttpResponseCache.install
import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.constraintlayout.compose.ConstraintLayout

import com.example.iesgrao.ui.theme.IESGRAOTheme


class Home : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IESGRAOTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppStructure()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppStructure() {
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = { MyTopAppBar() },
        content = { innerPadding ->
            MyContent(innerPadding)
        },
        bottomBar = { MyBottomNavigation() },
        floatingActionButtonPosition = FabPosition.End,
     //   floatingActionButton = { MyFAB() }
    )
}

 //@Composable
//fun MyFAB() {

//}

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
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "Horario del Alumno"
                )
            },
            label = { Text("Mi Horario") }
        )
        NavigationBarItem(
            selected = index == 1,
            onClick = { index = 1 },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Página main"
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


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MyContent(innerPadding: PaddingValues) {
    ConstraintLayout(modifier = Modifier
        .fillMaxSize()
        .padding(25.dp))


    {
        val welcome = createRef()

        Column(modifier = Modifier
            .padding(16.dp)
            .constrainAs(welcome) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

            }) {
            Spacer(modifier = Modifier.padding(17.dp))
            Text(text = "Bienvenido a la App Oficial del IES Grao")

        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar() {
    TopAppBar(
        title = {
            Text(
                "Menú del Alumno",
                fontWeight = FontWeight.Bold
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.LightGray),
        navigationIcon = {
            IconButton(onClick = { }) { Icon(Icons.Filled.Menu, contentDescription = null) }
        },
        actions = {
            IconButton(onClick = {}) { Icon(Icons.Filled.Add, contentDescription = null) }
            Spacer(modifier = Modifier.size(6.dp))
            IconButton(onClick = {}) { Icon(Icons.Filled.Close, contentDescription = null) }
        }
    )
}

@Composable
fun YouTubeVideo(videoId: String) {
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                webViewClient = WebViewClient()
                loadUrl("https://youtu.be/s5gPlJJul24?si=xbUYJorevljxpI4I$videoId")
                settings.javaScriptEnabled = true
            }
        }
    )
}





@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    IESGRAOTheme {
        AppStructure()
      // YouTubeVideo(videoId = "uCa9G1UBlokBKtav")
    }
}