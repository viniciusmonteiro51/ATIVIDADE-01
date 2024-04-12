package com.br.dispositivosmoveis.atividade01.screen

import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.br.dispositivosmoveis.atividade01.api.ErrorReponse
import com.br.dispositivosmoveis.atividade01.model.Usuario
import com.br.dispositivosmoveis.atividade01.viewModel.AuthViewModel

@Composable
fun LoginScreen(navController: NavController) {
    val authViewModel = viewModel<AuthViewModel>()
    
    var email by remember { mutableStateOf("")}
    var senha by remember { mutableStateOf("")}
    var error by remember { mutableStateOf("")}

    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.padding(top = 60.dp))
            if(error.isNotEmpty()) {
                Text(text = error)
            }
            Text(text = "Login")


            OutlinedTextField(
                modifier = Modifier
                    .padding(15.dp)
                    .width(350.dp),
                value = email,
                onValueChange = {email = it},
                label = {Text(text = "Usuário")}
            )
            OutlinedTextField(
                modifier = Modifier
                    .padding(bottom = 45.dp)
                    .width(350.dp),
                value = senha,
                onValueChange = {senha = it},
                label = { Text(text = "Senha")}
            )
            
            Button(
                onClick = {
                    error = ""
                    authViewModel.login(
                    email,
                    senha,
                    onError = {
                        message -> error = message
                    }
                )
            }
            ) {
                Text(text = "Logar")
            }

        }
    }
}

