package com.example.project_application
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.project_application.R as AppR
import com.example.project_application.adapter.CustomerAPI
import com.example.project_application.adapter.Retrofitservice
import com.example.project_application.model.Customer
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private lateinit var emailEditText: TextInputEditText
    private lateinit var passwordEditText: TextInputEditText
    private lateinit var loginButton: Button
    private lateinit var forgotPasswordButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(AppR.layout.activity_login)

        emailEditText = findViewById(AppR.id.emailconfirm)
        passwordEditText = findViewById(AppR.id.loginpass)
        loginButton = findViewById(AppR.id.concludelogin)
        forgotPasswordButton = findViewById(AppR.id.changepass)

        loginButton.setOnClickListener {
            loginUser()
        }

        forgotPasswordButton.setOnClickListener {
            val intent = Intent(this@LoginActivity, NewpassActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loginUser() {
        val userEmail = emailEditText.text.toString()
        val userPassword = passwordEditText.text.toString()

        val customerAPI = Retrofitservice().retrofit.create(CustomerAPI::class.java)
        val call = customerAPI.allCustomers

        call.enqueue(object : Callback<List<Customer>> {
            override fun onResponse(call: Call<List<Customer>>, response: Response<List<Customer>>) {
                if (response.isSuccessful) {
                    val customers = response.body()

                    // Verificar se há um cliente com o email e senha fornecidos
                    val matchingCustomer = customers?.find { it.email == userEmail && it.password == userPassword }

                    if (matchingCustomer != null) {
                        // Sucesso! O email e a senha correspondem a um cliente
                        val intent = Intent(this@LoginActivity, productsActivity::class.java)
                        startActivity(intent)
                    } else {
                        // Falha! Email ou senha incorretos
                        Toast.makeText(this@LoginActivity, "Credenciais inválidas", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    // Falha na chamada da API
                    Toast.makeText(this@LoginActivity, "Erro ao obter clientes", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Customer>>, t: Throwable) {
                // Falha na chamada da API
                Toast.makeText(this@LoginActivity, "Erro ao obter clientes", Toast.LENGTH_SHORT).show()
            }
        })
    }
}

