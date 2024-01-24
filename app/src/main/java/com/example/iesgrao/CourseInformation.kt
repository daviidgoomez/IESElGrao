package com.example.iesgrao

data class CourseInformation(val nombre_curso: String, val grupo: String, val descripcion: String?)

val courses = mutableListOf(
    CourseInformation("1ºDAM","Clase única","Desarrollo de Aplicaciones Multiplataforma"), // 0
    CourseInformation("2ºDAM","Clase única","Desarrollo de Aplicaciones Multiplataforma II"), // 1
    CourseInformation("3ºESO","A","Educación Secundaria Obligatoria"), // 2
    CourseInformation("3ºESO","B","Educación Secundaria Obligatoria"), // 3
    CourseInformation("1ºSMR","A","Primero de Informática"), // 4
    CourseInformation("2ºBachiller", "B","Segundo de Bachiller"), // 5
    CourseInformation("1ºESO","C","Educación Secundaria Obligatoria") // 6
)
