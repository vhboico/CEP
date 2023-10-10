package com.example.cep.repositorio

import com.example.cep.data.DataSource
import com.example.cep.listener.RespostaApi
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class Repositorio @Inject constructor(private val dataSource: DataSource) {

    fun respostaApi(cep: String, respostaApi: RespostaApi){
        dataSource.respostaApi(cep, respostaApi)
    }
}