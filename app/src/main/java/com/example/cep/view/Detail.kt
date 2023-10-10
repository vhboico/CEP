package com.example.cep.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cep.ui.theme.Teal700
import com.example.cep.ui.theme.White

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Detail(
    navController: NavController,
    logradouro: String,
    bairro: String,
    cidade: String,
    estado: String
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Buscador de Cep",
                        fontSize = 18.sp
                    )
                },
                backgroundColor = Teal700,
                contentColor = White
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Este é o seu endereço: ",
                fontSize = 30.sp,
                modifier = Modifier.padding(20.dp)
            )
            Text(text = logradouro, fontSize = 22.sp, fontWeight = FontWeight.Medium)
            Text(text = bairro, fontSize = 20.sp, fontWeight = FontWeight.Medium)
            Text(text = cidade, fontSize = 20.sp, fontWeight = FontWeight.Medium)
            Text(text = estado, fontSize = 20.sp, fontWeight = FontWeight.Medium)
        }

    }
}