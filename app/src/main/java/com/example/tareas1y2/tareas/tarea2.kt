package com.example.tareas1y2.tareas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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

@Composable
fun MayorMenorScreen() {
    var numero1: Int by remember {
        mutableStateOf(0)
    }
    var numero2: Int by remember {
        mutableStateOf(0)
    }
    var numero3: Int by remember {
        mutableStateOf(0)
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
            value = numero1.toString(),
            onValueChange = { numero1 = checkWroteNumber_(it) },
            label = { Text(text = "Primer número") },
            placeholder = { Text(text = "Ingresa el número") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = numero2.toString(),
            onValueChange = { numero2 = checkWroteNumber_(it) },
            label = { Text(text = "Segundo número") },
            placeholder = { Text(text = "Ingresa el número") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = numero3.toString(),
            onValueChange = { numero3 = checkWroteNumber_(it) },
            label = { Text(text = "Tercer número") },
            placeholder = { Text(text = "Ingresa el número") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(
            onClick = {
                val minimo = minOf(numero1, numero2, numero3)
                val maximo = maxOf(numero1, numero2, numero3)
                resultado = "El menor es: $minimo\nEl mayor es: $maximo"
            },
            colors = ButtonDefaults.buttonColors(Color(0xFF5F888D))
        ) {
            Text(text = "Calcular Mayor y Menor")
        }

        Text(text = resultado)
    }
}

fun checkWroteNumber_(text: String): Int {
    return text.toIntOrNull() ?: 0
}


@Preview(showBackground = true)
@Composable
fun MayorMenorPreview() {
    Tareas1y2Theme {
        MayorMenorScreen()
    }
}
