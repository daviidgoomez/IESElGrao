package com.example.iesgrao

import android.icu.text.SimpleDateFormat
import java.util.Date

data class TeacherInformation(
    val DNI: String,
    val password: String,
    val nombre: String,
    val apellidos: String,
    val correo: String,
    val direccion: String,
    val cod_postal: String,
    val edad: Int,
    val fecha_inicio: Date
)

val teachers = mutableListOf(
    TeacherInformation(
        "12345678J", "SoyJordiCrack", "Jordi",
        "Jiménez Vidal", "jjvidal@ieselgrao.org", "Peluquería Ubuntu",
        "46011", 47, SimpleDateFormat("dd/MM/yyyy").parse("09/09/2008")
    ),
    TeacherInformation(
        "98765432X", "TeacherPass123", "María",
        "Gómez Martínez", "maria.gomez@example.com", "Laboratorio 3",
        "28001", 35, SimpleDateFormat("dd/MM/yyyy").parse("15/05/2015")
    ),
    TeacherInformation(
        "56789012A", "Prof1234", "Carlos",
        "Sánchez Ruiz", "carlos.sanchez@example.com", "Despacho 105",
        "37001", 42, SimpleDateFormat("dd/MM/yyyy").parse("03/12/2012")
    ),
    TeacherInformation(
        "34567890B", "Maestro456", "Laura",
        "Fernández López", "laura.fernandez@example.com", "Aula 22",
        "08001", 38, SimpleDateFormat("dd/MM/yyyy").parse("20/08/2017")
    ),
    TeacherInformation(
        "11223344C", "Password789", "Antonio",
        "Martín Sánchez", "antonio.martin@example.com", "Despacho 205",
        "41005", 51, SimpleDateFormat("dd/MM/yyyy").parse("10/02/2005")
    )
)