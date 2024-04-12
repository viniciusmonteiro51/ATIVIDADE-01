package com.br.dispositivosmoveis.atividade01.api.response

import com.br.dispositivosmoveis.atividade01.model.Usuario

data class LoginResponseBody(
    val token: String = "",
    var usuario: Usuario
)