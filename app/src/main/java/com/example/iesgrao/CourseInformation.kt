package com.example.iesgrao

data class CourseInformation(val nombre_curso: String, val grupo: String, val descripcion: String?)

val courses = mutableListOf(
    CourseInformation("1ºDAM","Clase única","Desarrollo de Aplicaciones Multiplataforma"),
    CourseInformation("2ºDAM","Clase única","Desarrollo de Aplicaciones Multiplataforma II"),
    CourseInformation("3ºESO","A","Educación Secundaria Obligatoria"),
    CourseInformation("3ºESO","B","Educación Secundaria Obligatoria"),
)
