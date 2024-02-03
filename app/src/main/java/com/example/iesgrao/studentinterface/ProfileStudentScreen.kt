package com.example.iesgrao.studentinterface

import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.iesgrao.R
import com.example.iesgrao.datafiles.students

@Composable
fun MyContentProfile(innerPadding: PaddingValues) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(modifier = Modifier.padding(top = 60.dp)) {
            Divider(
                modifier = Modifier
                    .padding(2.dp),
                color = Color.LightGray
            )

            Text(
                text = "Tu Perfil",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.primary
            )

            Divider(
                modifier = Modifier
                    .padding(2.dp)
                    .padding(top = 2.dp),
                color = Color.LightGray
            )

            StudentProfile()

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Contacta con el administrador " +
                        "\npara realizar modificaciones.",
                modifier = Modifier
                    .padding(bottom = 6.dp),
                fontStyle = FontStyle.Italic,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun StudentProfile() {
    val student = students[0]

    Column(modifier = Modifier.padding(4.dp)) {
        ProfileItem("Nombre", student.nombre)
        ProfileItem("Apellidos", student.apellidos)
        ProfileItem("NIA", student.NIA)
        ProfileItem("DNI", student.DNI)
        ProfileItem("Edad", student.edad.toString())
        ProfileItem("Correo", student.correo)
        ProfileItem("Dirección", student.direccion)
        ProfileItem("Código Postal", student.cod_postal)
        ProfileItem(
            "Alumno desde",
            SimpleDateFormat("dd/MM/yyyy").format(student.fecha_alta)
        )
        ProfileItem("Curso", student.curso.nombre_curso)
    }

    Divider(
        modifier = Modifier
            .padding(2.dp)
            .padding(top = 8.dp),
        color = Color.LightGray
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Datos protegidos por GVA",
            modifier = Modifier
                .padding(top = 28.dp),
            color = Color.Red,
            textAlign = TextAlign.Center
        )
        Image(
            painter = painterResource(id = R.drawable.gva),
            contentDescription = "GVA 2024",
            modifier = Modifier
                .padding(5.dp, top = 5.dp)
                .height(88.dp)
                .size(60.dp)
        )
    }
}
@Composable
fun ProfileItem(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(
            text = "$label: ",
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )
        Text(
            text = value,
            modifier = Modifier.weight(1f),
            color = MaterialTheme.colorScheme.primary
        )
    }
}
