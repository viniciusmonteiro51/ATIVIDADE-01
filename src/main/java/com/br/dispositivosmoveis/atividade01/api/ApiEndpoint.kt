package com.br.dispositivosmoveis.atividade01.api

import com.br.dispositivosmoveis.atividade01.api.request.LoginRequestBody
import com.br.dispositivosmoveis.atividade01.api.response.LoginResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiEndpoint {
    @POST("/login")
    suspend fun login(@Body requestBody: LoginRequestBody) : Response<LoginResponseBody>
}