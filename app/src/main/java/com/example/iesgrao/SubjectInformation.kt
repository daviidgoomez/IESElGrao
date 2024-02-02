package com.example.iesgrao

import androidx.annotation.DrawableRes

data class SubjectInformation(
    val id_subject: String,
    val nombre: String,
    val num_horas: Int,
    val descripcion: String?,
    val curso : CourseInformation,
    @DrawableRes val picture: Int
)
val subjects = mutableListOf(
    SubjectInformation("subject001","Acceso a Datos",230,
        "Acceso a ficheros, bases de datos relacionales (restricciones), MongoDB (DB noSQL)" +
                "y Proyecto Iberdrola", courses[1], R.drawable.acceso_a_datos),

    SubjectInformation("subject002","Programación de Aplicaciones Multimedia",200,
        "Lenguaje de programación Kotlin, desarrollo de Apps en Kotlin con XML y Jetpack Compose y Unity"
    , courses[1], R.drawable.jetpack_compose),
    SubjectInformation("subject003","Bases de Datos",1000,"Fundamentos" +
            "de las Bases de Datos relacionales" , courses[1], R.drawable.base_de_datos),
    SubjectInformation("subject003","Sistemas de Gestión Empresarial",200,
        "Conocimiento sobre lo que es un ERP, aprendiazaje de python y desarollo de módulos de" +
                " Odoo", courses[1], R.drawable.odoo),
    SubjectInformation("subject004","Programación de Servicios y Procesos",160,
        "Lanzamiento y ejecución de hilos en java", courses[1], R.drawable.psp)
)
