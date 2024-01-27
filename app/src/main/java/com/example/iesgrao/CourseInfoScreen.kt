package com.example.iesgrao

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.iesgrao.ui.theme.IESGRAOTheme

@Composable
fun MyInfoContent(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Text(
                text = "Información",
                modifier = Modifier
                    .fillMaxWidth(),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(8.dp))

            Divider(modifier = Modifier.fillMaxWidth())
        }

        item {
            InfoList()
        }

        }
    }


@Composable
fun InfoList() {
    val courseInfo = courses.getOrNull(1)

    courseInfo?.let {
        Column(modifier = Modifier.padding(4.dp)) {
            InfoItem(text = it.informacion.toString())
        }
    }
}

@Composable
fun InfoItem(text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(
            text = text,
            modifier = Modifier.weight(1f),
            color = Color.Black
        )
    }
}

@Composable
@Preview(showBackground = true)
fun CourseInfoPreview() {
    IESGRAOTheme {
        val navController = rememberNavController()
        MyInfoContent(navController = navController)
    }
}
