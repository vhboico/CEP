package com.example.cep.listener

interface RespostaApi {

    fun onSucess(logradouro: String, bairro: String, localidade: String, uf: String)
    fun onFailure(erro: String)

}