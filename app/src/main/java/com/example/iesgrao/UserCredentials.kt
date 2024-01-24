package com.example.iesgrao

private val StudentCredentials = mapOf(
    "11955735" to "gom180703",
    "12345555" to "dam180703",
    "11234567" to "cms180703",
    "11032178" to "mol160408",
    "admin" to "admin123"
)

private val TeacherCredentials = mapOf(
    "12345678J" to "SoyJordiCrack"
)

private val AdminCredentials = mapOf(
    "88888888D" to "NoVamosaLlegar"
)

fun isValidCredentialsStudent(username: String, password: String): Boolean {
    return StudentCredentials[username] == password
}

fun isValidCredentialsTeacher(username: String, password: String): Boolean {
    return TeacherCredentials[username] == password
}

fun isValidCredentialsAdmin(username: String, password: String): Boolean {
    return AdminCredentials[username] == password
}