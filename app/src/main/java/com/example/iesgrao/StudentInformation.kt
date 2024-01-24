package com.example.iesgrao

import android.icu.text.SimpleDateFormat
import java.util.Date

data class StudentInformation(
    val NIA: String,
    val password: String,
    val nombre: String,
    val apellidos: String,
    val DNI: String,
    val correo: String,
    val direccion: String,
    val cod_postal: String,
    val edad: Int,
    val fecha_alta: Date,
    val curso: CourseInformation
)
val students = mutableListOf(
    StudentInformation(
        "11955735", "gom180703", "David", "Gómez Korotkich",
        "48262835A", "11955735@ieselgrao.org", "Calle de la Reina 28º", "46011",
        20, SimpleDateFormat("dd/MM/yyyy").parse("20/07/2020"),
        courses[1]
    ),
    StudentInformation(
        "12345555", "dam180703", "Ana", "Martínez López",
        "53216287B", "12345555@example.com", "Avenida del Sol 45", "28001",
        22, SimpleDateFormat("dd/MM/yyyy").parse("15/09/2021"),
        courses[0]
    ),
    StudentInformation(
        "11234567", "cms180703", "Carlos", "Sánchez Ruiz",
        "63257421C", "11234567@example.com", "Plaza Mayor 7", "37001",
        12, SimpleDateFormat("dd/MM/yyyy").parse("10/05/2019"),
        courses[6]
    ),
    StudentInformation(
        "11032178", "mol160408", "Marta", "Oliver García",
        "74586321D", "11032178@example.com", "Calle del Mar 15", "08001",
        18, SimpleDateFormat("dd/MM/yyyy").parse("05/12/2022"),
        courses[1]
    ),
    StudentInformation(
        "98765432", "abc123", "Juan", "Pérez Rodríguez",
        "98765432X", "juan.perez@example.com", "Calle de la Luna 3", "41005",
        28, SimpleDateFormat("dd/MM/yyyy").parse("02/03/2018"),
        courses[0]
    )
)

