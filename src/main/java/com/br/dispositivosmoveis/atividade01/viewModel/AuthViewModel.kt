package com.br.dispositivosmoveis.atividade01.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.br.dispositivosmoveis.atividade01.api.ErrorReponse
import com.br.dispositivosmoveis.atividade01.api.RetrofitClient.ApiClient
import com.br.dispositivosmoveis.atividade01.api.request.LoginRequestBody
import com.google.gson.Gson
import kotlinx.coroutines.launch


class AuthViewModel: ViewModel() {
    val error = mutableStateOf("")

    fun login(
        email: String,
        senha: String,
        onError: (String) -> Unit
    ) {
        val requestBody = LoginRequestBody()
        requestBody.email = email
        requestBody.senha = senha

        viewModelScope.launch {

            val response = ApiClient.apiEndpoint.login(requestBody)
            if (response.isSuccessful) {
                response.body()?.let { responseBody ->
                    println(responseBody)
                }
            } else {
                response.errorBody()?.let { responseBody ->
                    val errorReponse = Gson().fromJson(responseBody.source().readUtf8(), ErrorReponse::class.java)
                    error.value = errorReponse.message
                    onError(error.value)
                    println(error.value)
                }
            }
        }
    }
}