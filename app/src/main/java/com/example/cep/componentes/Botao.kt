package com.example.cep.componentes

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.cep.ui.theme.Teal700
import com.example.cep.ui.theme.White

@Composable
fun Botao(
    modifier: Modifier,
    onClick: () -> Unit,
    texto: String
) {
    Button(
        onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Teal700,
            contentColor = White
        ),
        modifier = modifier,
    ) {
        Text(text = texto,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold)
    }
}

@Preview
@Composable
private fun BotaoPreview(){
    Botao(modifier = Modifier.fillMaxWidth(), onClick = { /*TODO*/ }, texto = "Buscar CEP")
}