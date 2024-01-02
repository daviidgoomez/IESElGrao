package com.example.iesgrao

import android.content.Intent
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxScopeInstance.align
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScopeInstance.align
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.KeyboardType.Companion.Uri
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.iesgrao.ui.theme.IESGRAOTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IESGRAOTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen(onLoginClicked = {_, _ -> })
                    linkPage()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(onLoginClicked: (String, String) -> Unit) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
   // var isPasswordVisible by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Espacio en blanco en la parte superior
        Spacer(modifier = Modifier.height(16.dp))
        // Imagen o logo de la empresa
        Image(
            painter = painterResource(id = R.drawable.grao2),
            contentDescription = null,
            modifier = Modifier
                .size(155.dp)
                .align(Alignment.CenterHorizontally)
        )
        // Espacio en blanco entre la imagen y los campos de texto
        Spacer(modifier = Modifier.height(24.dp))

        // Campo de texto para el nombre de usuario
        OutlinedTextField(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            value = username,
            onValueChange = { username = it },
            label = { Text("Introduce tu nombre de usuario") },
            singleLine = true, // Establece si el texto es puede ocupar una línea o más. En caso de true, solo permite una línea
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Text,
                autoCorrect = true
            ),
            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription = null)
            }
        )
        // Espacio en blanco entre el campo de texto de usuario y el de password
        Spacer(modifier = Modifier.height(16.dp))

        // Campo de texto para la password
        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.CenterHorizontally),
            value = password,
            onValueChange = { password = it },
            label = { Text("Introduce la contraseña") },
            singleLine = true,
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = null)
            }
        )

        // Espacio en blanco entre el campo de texto de contraseña y el botón de inicio de sesión
        Spacer(modifier = Modifier.height(16.dp))

        // Botón de inicio de sesión
        Button(
            onClick = {
              // Próxima lógica para pasar de pantalla
                onLoginClicked(username, password)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(53.dp),
            enabled = !isLoading
        ) {
            if (isLoading) {
                // Muestra un indicador de carga si está en progreso
                CircularProgressIndicator(
                    modifier = Modifier.size(26.dp),
                    color = MaterialTheme.colorScheme.primary
                )
            } else {
                // Texto del botón de inicio de sesión
                Text("Iniciar sesión")
            }
        }
        
        // Mostrar errores (si hay)
        errorMessage?.let { 
            Text(
                text = it,
                color = Color.Red,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
                    .alpha(0.8f)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        // Enlace o texto adicional (puede ser un enlace "¿Olvidaste tu contraseña?")
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)) {
    }


    }
}

@Composable
fun linkPage() {
    // Obtener el contexto local
    val context = LocalContext.current

    // Crear un AnnotatedString con un estilo de texto y un enlace

    val text = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Blue)) {
            append("Haz clic aquí para visitar nuestra página web. ")
            addStringAnnotation(
                tag = "URL",
                annotation = "https://portal.edu.gva.es/ieselgrao/?page_id=690&lang=es",
                start = 13,
                end = 37
            )
        }
    }
    ClickableText(text = text,
        modifier = Modifier.padding(16.dp, top = 600.dp),
        
         onClick = {
        offset ->
        text.getStringAnnotations(tag = "URL", start = offset,
            end = offset).firstOrNull().let { annotation ->
            val intent = Intent(Intent.ACTION_VIEW)
            context.startActivity(intent)
        }
    })
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IESGRAOTheme {
        LoginScreen(onLoginClicked = {_, _ -> })
        linkPage()
    }
}