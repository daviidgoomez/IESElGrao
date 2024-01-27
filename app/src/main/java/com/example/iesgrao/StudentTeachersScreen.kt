import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.iesgrao.NavigationActivity
import com.example.iesgrao.subjects
import com.example.iesgrao.teachers
import com.example.iesgrao.ui.theme.IESGRAOTheme

@Composable
fun MyTeachers(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { navController.navigate(NavigationActivity.HomeScreenStudent.route) },
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(8.dp)
                ) {
                    Icon(Icons.Filled.Home, contentDescription = "Home", tint = Color.White)
                }

                Spacer(modifier = Modifier.width(7.dp))

                Text(
                    text = "Mis profesores",
                    modifier = Modifier
                        .align(Alignment.CenterVertically),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Divider(modifier = Modifier.fillMaxWidth())
        }

        items(teachers.size) { index ->
            TeacherItem(
                teachers[index].nombre,
                teachers[index].apellidos,
                teachers[index].correo,
                subjects[index].nombre
            )
            Divider(modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth())
        }

        item {
            Spacer(modifier = Modifier.padding(10.dp))
            FloatingActionButton(
                onClick = { navController.navigate(NavigationActivity.HomeScreenStudent.route) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Volver al Home", fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun TeacherItem(nombre: String, apellidos: String, correo: String, asignatura: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Icon(
                Icons.Filled.Person,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(text = "$nombre $apellidos", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Asignatura: $asignatura", color = Color.Gray)
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {

                }
            ) {
                Icon(Icons.Filled.MailOutline, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = correo, color = MaterialTheme.colorScheme.primary)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun TeachersPreview() {
    IESGRAOTheme {
        val navController = rememberNavController()
        MyTeachers(navController = navController)
    }
}