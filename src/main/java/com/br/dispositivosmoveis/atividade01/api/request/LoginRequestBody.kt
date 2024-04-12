package com.br.dispositivosmoveis.atividade01.api.request

data class LoginRequestBody(
    var email: String = "",
    var senha: String = ""
)