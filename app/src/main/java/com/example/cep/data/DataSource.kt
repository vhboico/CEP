package com.example.cep.data

import com.example.cep.api.Api
import com.example.cep.listener.RespostaApi
import com.example.cep.model.Endereco
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


class DataSource @Inject constructor(){

    private val retrofit: Api = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://viacep.com.br/")
        .build()
        .create(Api::class.java)

    fun respostaApi(cep: String, respostaApi: RespostaApi){
        if (cep.isEmpty()){
            respostaApi.onFailure("Preencha o campo de CEP")
        } else{
            retrofit.setCep(cep).enqueue(object : Callback<Endereco>{
                override fun onResponse(call: Call<Endereco>, response: Response<Endereco>) {
                    if (response.code() == 200){
                        val logradouro = response.body()?.logradouro.toString()
                        val bairro = response.body()?.bairro.toString()
                        val localidade = response.body()?.localidade.toString()
                        val uf = response.body()?.uf.toString()

                        respostaApi.onSucess(logradouro,bairro,localidade,uf)
                    }else{
                        respostaApi.onFailure("CEP Inválido")
                    }
                }

                override fun onFailure(call: Call<Endereco>, t: Throwable) {
                    respostaApi.onFailure("Erro inesperado")
                }

            })
        }
    }
}