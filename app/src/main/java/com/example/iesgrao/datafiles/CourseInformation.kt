package com.example.iesgrao.datafiles

data class CourseInformation(
    val nombre_curso: String,
    val grupo: String,
    val descripcion: String?,
    val informacion: String?
)

val courses = mutableListOf(
    CourseInformation("1ºDAM","Clase única","Desarrollo de Aplicaciones Multiplataforma", null), // 0
    CourseInformation("2ºDAM","Clase única","Desarrollo de Aplicaciones Multiplataforma II", "Estimados estudiantes de 2ºDAM,\n" +
            "\n" +
            "Es un placer dar inicio a un nuevo curso académico en el Instituto de Educación Secundaria Grao. En este ciclo formativo de Desarrollo de Aplicaciones Multiplataforma, nos embarcamos en una travesía educativa que promete ampliar sus conocimientos y habilidades en el ámbito del desarrollo de software.\n" +
            "\n" +
            "Normas y Regulaciones:\n" +
            "\n" +
            "Con el objetivo de mantener un entorno propicio para el aprendizaje, recordamos la importancia de adherirse a las normas y regulaciones establecidas por el instituto. La puntualidad en las clases, la participación activa y el respeto hacia compañeros y profesores son fundamentales para un desarrollo académico armonioso. Cualquier infracción será tratada con la debida seriedad.\n" +
            "\n" +
            "Calendario Académico:\n" +
            "\n" +
            "El calendario académico, disponible en nuestra plataforma en línea, detalla las fechas clave del semestre. En él encontrarán información sobre exámenes, entregas de proyectos y sesiones de tutoría. Les recomendamos revisarlo regularmente para estar al tanto de posibles cambios o actualizaciones.\n" +
            "\n" +
            "Fechas de Recuperación:\n" +
            "\n" +
            "Para aquellos estudiantes que requieran recuperación en alguna asignatura, se han establecido fechas específicas para las evaluaciones. Les instamos a prepararse de manera adecuada, ya que estas pruebas son vitales para reforzar el conocimiento adquirido.\n" +
            "\n" +
            " Estructura del Curso:\n" +
            "\n" +
            "En cuanto a la estructura del curso, hemos diseñado un programa integral que abarca desde los conceptos fundamentales hasta aplicaciones más avanzadas. Los profesores estarán disponibles en horarios designados para consultas y aclaraciones. Les animamos a participar activamente en las discusiones en línea y a aprovechar los recursos disponibles en nuestra plataforma virtual.\n" +
            "\n" +
            "En resumen, este curso representa una oportunidad única para adquirir habilidades valiosas en el campo del desarrollo de aplicaciones multiplataforma. Esperamos un semestre productivo y enriquecedor para todos ustedes.\n" +
            "\n" +
            "Atentamente,\n" +
            "\n" +
            "David Antolín\n" +
            "IES Grao"), // 1
    CourseInformation("3ºESO","A","Educación Secundaria Obligatoria", null), // 2
    CourseInformation("3ºESO","B","Educación Secundaria Obligatoria", null), // 3
    CourseInformation("1ºSMR","A","Primero de Informática", null), // 4
    CourseInformation("2ºBachiller", "B","Segundo de Bachiller", null), // 5
    CourseInformation("1ºESO","C","Educación Secundaria Obligatoria", null) // 6
)
