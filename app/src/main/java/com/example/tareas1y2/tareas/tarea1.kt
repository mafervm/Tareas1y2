package com.example.tareas1y2.tareas

import android.text.TextUtils
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tareas1y2.ui.theme.Tareas1y2Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalificacionScreen() {
    var materia1: Double by remember {
        mutableStateOf(0.0)
    }
    var materia2: Double by remember {
        mutableStateOf(0.0)
    }
    var materia3: Double by remember {
        mutableStateOf(0.0)
    }
    var resultado: String by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = materia1.toString(),
            onValueChange = { materia1 = checkWroteNumber(it) },
            label = { Text(text = "Calificación de la primera materia") },
            placeholder = { Text(text = "Ingresa la calificación") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = materia2.toString(),
            onValueChange = { materia2 = checkWroteNumber(it) },
            label = { Text(text = "Calificación de la segunda materia") },
            placeholder = { Text(text = "Ingresa la calificación") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = materia3.toString(),
            onValueChange = { materia3 = checkWroteNumber(it) },
            label = { Text(text = "Calificación de la tercera materia") },
            placeholder = { Text(text = "Ingresa la calificación") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(
            onClick = {
                val promedio = (materia1 + materia2 + materia3) / 3.0
                if (promedio < 7) {
                    resultado = "El alumno repetirá el semestre."
                } else if (promedio < 8.5) {
                    resultado = "Has perdido el 5% de beca."
                } else {
                    resultado = "¡Felicidades! Eres un estudiante de honor."
                }
            },
            colors = ButtonDefaults.buttonColors(Color(0xFF748D5F))
        ) {
            Text(text = "Calcular")
        }

        Text(text = resultado)
    }
}

fun checkWroteNumber(text: String): Double {
    return if (text.toDoubleOrNull() != null) {
        text.toDouble()
    } else if (TextUtils.isEmpty(text)) {
        0.0
    } else {
        1.0
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Tareas1y2Theme {
        CalificacionScreen()
    }
}
