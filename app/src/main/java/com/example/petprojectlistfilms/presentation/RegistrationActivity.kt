package com.example.petprojectlistfilms.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.petprojectlistfilms.R

class RegistrationActivity : AppCompatActivity() {

    private lateinit var viewModel: RegistrationViewModel

    private val loginEditText by lazy {
        findViewById<EditText>(R.id.loginEditText)
    }
    private val passwordEditText by lazy {
        findViewById<EditText>(R.id.passwordEditText)
    }
    private val loginButton by lazy {
        findViewById<Button>(R.id.loginButton)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[RegistrationViewModel::class.java]
        if(!viewModel.checkIsLogin()) {
            setContentView(R.layout.activity_registration)

            loginButton.setOnClickListener {
                viewModel.registration(
                    loginEditText.text.toString(),
                    passwordEditText.text.toString()
                )
                startActivityMain()
            }

        }else{
            startActivityMain()
        }


    }

    fun startActivityMain(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}