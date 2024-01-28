package com.example.iesgrao

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.iesgrao.ui.theme.IESGRAOTheme

@Composable
fun MyErasmus(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        item {
            SectionTitle(text = "¿Qué es Erasmus Plus?")
            ErasmusDescription()
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
            SectionTitle(text = "Proyectos y Acreditaciones")
            MoreOptions(navController)
        }

        item {




        }
    }
}

@Composable
fun SectionTitle(text: String) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        color = MaterialTheme.colorScheme.primary,
        textAlign = TextAlign.Center
    )

    Divider(modifier = Modifier.fillMaxWidth())
}

@Composable
fun ErasmusDescription() {
    Spacer(modifier = Modifier.padding(5.dp))
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "El Parlamento Europeo ha aprobado el programa Erasmus+ para el período 2021-2027.\n" +
                        "\n" +
                        "El nuevo programa Erasmus + se enmarca en la estrategia Europa 2020, en la estrategia Educación y Formación 2020 y en la estrategia Rethinking Education y engloba todas las iniciativas de educación, formación, juventud y deporte.\n" +
                        "\n" +
                        "En materia educativa abarca todos los niveles: escolar, formación profesional, enseñanza superior y formación de personas adultas.\n" +
                        "\n" +
                        "Erasmus + integrará los programas existentes en el Programa de Aprendizaje Permanente y también los programas de educación superior internacional: Mundus, Tempus, ALFA, Edulink y programas bilaterales, además del Programa Juventud en Acción.\n" +
                        "\n" +
                        "Este nuevo programa se centra en el aprendizaje formal e informal más allá de las fronteras de la UE, con una clara vocación de internacionalización abriéndose a terceros países con el objetivo de mejorar las capacidades educativas y formativas de las personas para la empleabilidad de estudiantes, profesorado y trabajadores y trabajadoras.",
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}

@Composable
fun MoreOptions(navController: NavController) {
    val uriHandler = LocalUriHandler.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        FloatingActionButton(
            onClick = {
                navController.navigate(NavigationActivity.ErasmusAccreditations.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            content = {
                Text(text = "Ver Acreditaciones",
                    fontWeight = FontWeight.Bold)
            }
        )

        FloatingActionButton(
            onClick = {
                uriHandler.openUri(
                    uri = "https://portal.edu.gva.es/ieselgrao/?page_id=2799&lang=es"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            content = {
                Text(text = "Nuestros Proyectos",
                    fontWeight = FontWeight.Bold)
            }
        )
        Image(
            painter = painterResource(id = R.drawable.erasmus),
            contentDescription = null,
            modifier = Modifier
                .size(155.dp)
                .fillMaxWidth()
                .fillMaxHeight().align(Alignment.CenterHorizontally))
    }
}

@Preview(showBackground = true)
@Composable
fun ErasmusPreview() {
    IESGRAOTheme {
        ConstraintLayout {
            val navController = rememberNavController()
            MyErasmus(navController = navController)
        }
    }
}