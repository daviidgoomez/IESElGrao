package com.example.iesgrao.studentinterface

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.iesgrao.mainscreens.NavigationActivity
import com.example.iesgrao.ui.theme.IESGRAOTheme

@Composable
fun MySatisfaction(navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        item { SatisfactionQuestion() }
        item { SatisfactionDescription() }
        item { SatisfactionSlider() }
        item { SatisfactionTextField(navController = navController) }
    }
}

@Composable
fun SatisfactionQuestion() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "¿Estás satisfecho con nuestro centro?",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center
        )
        Divider()
    }
}

@Composable
fun SatisfactionDescription() {
Column(modifier = Modifier.padding(0.dp)) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {

        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle()) {
                    append("¡Tu opinión es fundamental para ")
                }
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("mejorar nuestro centro! ")
                }
                withStyle(style = SpanStyle()) {
                    append("\nPor favor, tómate un momento para completar esta breve encuesta de satisfacción. Queremos conocer tus experiencias y sugerencias para hacer que tu tiempo en nuestro centro sea aún mejor.")
                }
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, textDecoration = TextDecoration.Underline)) {
                    append("\n1. Responde ")
                }
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("honestamente")
                }
                withStyle(style = SpanStyle()) {
                    append(" cada pregunta.")
                }
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, textDecoration = TextDecoration.Underline)) {
                    append("\n2. Tu anonimato está garantizado.")
                }
                withStyle(style = SpanStyle(fontStyle = FontStyle.Italic)) {
                    append("\n3. Al finalizar, presiona \"Enviar\" para compartir tus respuestas.")
                }
            },
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

}


@Composable
fun SatisfactionSlider() {
    var sliderPosition by remember { mutableStateOf(0f) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            text = "!Arrastra según tu grado de satisfacción!",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center
        )
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 0f..10f,
            steps = 9
        )
        Text(text = "%.0f".format(sliderPosition))
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SatisfactionTextField(navController: NavController) {
    var textFieldValue by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "¿Algo que decirnos?",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center
        )

        TextField(
            value = textFieldValue,
            onValueChange = {
                textFieldValue = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp),
            textStyle = LocalTextStyle.current.copy(
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onBackground
            ),
            placeholder = {
                Text("Escribe aquí...")
            },
            singleLine = false,
            maxLines = 10,
            shape = MaterialTheme.shapes.small
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {  navController.navigate(NavigationActivity.SendScreen.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(imageVector = Icons.Default.Send, contentDescription = null)
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "Enviar")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SatisfactionPreview() {
    IESGRAOTheme {
        val navController = rememberNavController()
        MySatisfaction(navController = navController)
    }
}