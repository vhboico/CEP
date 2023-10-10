package com.example.cep.view

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cep.componentes.Botao
import com.example.cep.componentes.CaixaDeTexto
import com.example.cep.listener.RespostaApi
import com.example.cep.ui.theme.Teal700
import com.example.cep.ui.theme.White
import com.example.cep.viewmodel.BuscarCepViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BuscarCep(
    navController: NavController,
    viewModel: BuscarCepViewModel = hiltViewModel()
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

        val context = LocalContext.current

        var inputCep by remember {
            mutableStateOf("")
        }

        var inputLogradouro by remember {
            mutableStateOf("")
        }

        var inputBairro by remember {
            mutableStateOf("")
        }

        var inputCidade by remember {
            mutableStateOf("")
        }

        var inputEstado by remember {
            mutableStateOf("")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                CaixaDeTexto(
                    value = inputCep,
                    onValueChange = { inputCep = it },
                    label = "CEP",
                    modifier = Modifier
                        .width(200.dp)
                        .padding(20.dp, 50.dp, 20.dp, 10.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    )
                )

                Botao(
                    modifier = Modifier
                        .padding(0.dp, 60.dp, 20.dp, 10.dp)
                        .height(55.dp),
                    onClick = {
                        viewModel.respostaApi(inputCep, object : RespostaApi{
                            override fun onSucess(logradouro: String, bairro: String, localidade: String, uf: String) {
                                inputLogradouro = logradouro
                                inputBairro = bairro
                                inputCidade = localidade
                                inputEstado = uf
                            }

                            override fun onFailure(erro: String) {
                                Toast.makeText(context,erro, Toast.LENGTH_SHORT).show()
                            }

                        })
                    },
                    texto = "Buscar CEP"
                )
            }

            Column(
                Modifier.fillMaxWidth()
            ) {
                CaixaDeTexto(
                    value = inputLogradouro,
                    onValueChange = { inputLogradouro = it },
                    label = "Logradouro",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp, 0.dp, 20.dp, 10.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text
                    )
                )

                CaixaDeTexto(
                    value = inputBairro,
                    onValueChange = { inputBairro = it },
                    label = "Bairro",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp, 0.dp, 20.dp, 10.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text
                    )
                )

                CaixaDeTexto(
                    value = inputCidade,
                    onValueChange = { inputCidade = it },
                    label = "Cidade",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp, 0.dp, 20.dp, 10.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text
                    )
                )

                CaixaDeTexto(
                    value = inputEstado,
                    onValueChange = { inputEstado = it },
                    label = "Estado",
                    modifier = Modifier
                        .width(200.dp)
                        .padding(20.dp, 0.dp, 20.dp, 10.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text
                    )
                )

                Botao(
                    modifier = Modifier
                        .padding(20.dp)
                        .height(55.dp),
                    onClick = { },
                    texto = "Avançar"
                )
            }
        }
    }
}

@Preview
@Composable
private fun BuscarCepPreview() {
    BuscarCep(rememberNavController())
}