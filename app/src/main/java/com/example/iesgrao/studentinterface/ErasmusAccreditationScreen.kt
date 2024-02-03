package com.example.iesgrao.studentinterface

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.iesgrao.R
import com.example.iesgrao.mainscreens.NavigationActivity
import com.example.iesgrao.ui.theme.IESGRAOTheme

@Composable
fun MyAccreditation(navController: NavHostController) {
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        item { AccreditationContent() }
        item { ReturnToHome(navController = navController) }
        item { Footer() }

    }
}

@Composable
fun AccreditationContent() {
    Column(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.obj1),
            contentDescription = null,
            modifier = Modifier
                .size(130.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .align(Alignment.CenterHorizontally)
        )

        Objectives()

        Card {
            Column(modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()) {
                Text(
                    text = "Mejorar la competencia plurilingüe y la competencia comunicativa en lengua extranjera del alumnado y del profesorado.\n" +
                            "\nAumentar la competencia digital del profesorado según el nuevo marco común de la competencia digital docente para impulsar y consolidar el uso de metodologías y herramientas digitales.\n" +
                            "\nFavorecer la inclusión y reducir la conflictividad, atendiendo a la diversidad sociocultural del alumnado y poniendo de relieve la importancia de la interculturalidad.\n" +
                            "\nFortalecer las relaciones del centro con el tejido comunitario para favorecer una ciudadanía responsable y aumentar el impacto del aprendizaje del alumnado en el desarrollo de sus competencias.",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }

        }
        Image(
            painter = painterResource(id = R.drawable.obj2),
            contentDescription = null,
            modifier = Modifier
                .size(130.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .align(Alignment.CenterHorizontally))

        Objectives()

        Card {
            Column(modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()) {
                Text(
                    text = "Mejorar la competencia plurilingüe y la competencia comunicativa en lengua extranjera del alumnado y del profesorado.\n" +
                            "\nAumentar la competencia digital del profesorado según el nuevo marco común de la competencia digital docente para impulsar y consolidar el uso de metodologías y herramientas digitales.\n" +
                            "\nMejorar la empleabilidad del alumnado fomentando el pleno desarrollo de sus capacidades y favoreciendo la adquisición de las competencias y «soft skills» que faciliten su inserción en el mundo laboral.\n" +
                            "\nFortalecer las relaciones del centro con el tejido comunitario para favorecer una ciudadanía responsable y aumentar el impacto del aprendizaje del alumnado en el desarrollo de sus competencias.",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }

        }

    }

}

@Composable
fun ReturnToHome(navController: NavController) {
    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxSize()) {
        FloatingActionButton(
            onClick = {
                navController.navigate(NavigationActivity.HomeScreenStudent.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            content = {
                Text(text = "Volver al Home",
                    fontWeight = FontWeight.Bold)
            }
        )
    }
}

@Composable
fun Footer() {
    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxSize()) {

        Text(
            text = "Los proyectos KA120-SCH y KA120-VET están cofinanciados por el programa Erasmus+ de la Unión Europea. El contenido de la web es responsabilidad exclusiva del IES El Grao y ni la Comisión Europea, ni el Servicio Español para la Internacionalización de la Educación (SEPIE) son responsables del uso que pueda hacerse de la información aquí difundida.\n",
            modifier = Modifier.background(MaterialTheme.colorScheme.background.copy(alpha = 0.1f)),
            fontStyle = FontStyle.Italic,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center)

        Image(
            painter = painterResource(id = R.drawable.europe),
            contentDescription = null,
            modifier = Modifier
                .size(130.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .align(Alignment.CenterHorizontally))
    }
}

@Composable
fun Objectives() {
    Divider(modifier = Modifier.padding(2.dp))

    Text(
        text = "Objetivos",
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        color = MaterialTheme.colorScheme.primary,
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun ErasmusAccreditationsPreview() {
    IESGRAOTheme {
        ConstraintLayout {
            val navController = rememberNavController()
            MyAccreditation(navController = navController)
        }
    }
}