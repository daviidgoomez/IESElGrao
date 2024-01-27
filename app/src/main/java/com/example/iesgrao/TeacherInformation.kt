package com.example.iesgrao

import android.annotation.SuppressLint
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
    val fecha_inicio: Date,
    val curso: CourseInformation,
    val subject: SubjectInformation
)

@SuppressLint("SimpleDateFormat")
val teachers = mutableListOf(
    TeacherInformation(
        "12345678J", "SoyJordiCrack", "Jordi",
        "Jiménez Vidal", "jjvidal@ieselgrao.org", "Peluquería Ubuntu",
        "46011", 47, SimpleDateFormat("dd/MM/yyyy").parse("09/09/2008"),
        courses[1], subjects[2]
    ),
    TeacherInformation(
        "98765432X", "TeacherPass123", "David",
        "Antolín", "antolindavid@ieselgrao.org", "Cabanyal",
        "28001", 33, SimpleDateFormat("dd/MM/yyyy").parse("15/05/2021"),
        courses[1], subjects[1]
    ),
    TeacherInformation(
        "56789012A", "Prof1234", "Marcos",
        "Gallarch", "mgallarch@ieselgrao.org", "Desconocido",
        "37001", 35, SimpleDateFormat("dd/MM/yyyy").parse("03/12/2014"),
        courses[1], subjects[0]
    ),
    TeacherInformation(
        "34567890B", "Maestro456", "Antonio",
        "Odoo", "toniodoo@ieselgrao.org", "OdooLand",
        "08001", 37, SimpleDateFormat("dd/MM/yyyy").parse("20/08/2013"),
        courses[1], subjects[3]
    ),
    TeacherInformation(
        "11223344C", "Password789", "Javier",
        "Llorens Anduix", "javillorens@ieselgrao.org", "Ausencias",
        "41005", 27, SimpleDateFormat("dd/MM/yyyy").parse("10/02/2023"),
        courses[1], subjects[4]
    )

)