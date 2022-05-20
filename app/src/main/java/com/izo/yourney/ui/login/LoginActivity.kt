package com.izo.yourney.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import android.widget.Button
import com.izo.yourney.R
import com.izo.yourney.databinding.ActivityLoginBinding
import com.izo.yourney.ui.MainActivity
import com.izo.yourney.ui.chatbot.ChatbotActivity
import com.izo.yourney.ui.persona.PersonaActivity
import com.izo.yourney.ui.register.RegisterActivity

//class LoginActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityLoginBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityLoginBinding.inflate(layoutInflater)
//        setContentView(binding.root)
////        supportActionBar?.hide()
//
//
//        binding.btnLogin.setOnClickListener {
//            val intent = Intent(this, PersonaActivity::class.java)
//            startActivity(intent)
//            finish()
//        }
//
//        binding.tvRegis.setOnClickListener {
//            val intent = Intent(this, RegisterActivity::class.java)
//            startActivity(intent)
//            finish()
//        }
//    }
//}

class LoginActivity : AppCompatActivity() {

    lateinit var binding : ActivityLoginBinding
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

//        binding.forgotPassword.setOnClickListener {
//            val intent = Intent(this, ResetPasswordActivity::class.java)
//            startActivity(intent)
//        }

        binding.tvRegis.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.edEmaill.text.toString()
            val password = binding.edPassword.text.toString()

            //Validasi email
            if (email.isEmpty()){
                binding.edEmaill.error = "Email Harus Diisi"
                binding.edEmaill.requestFocus()
                return@setOnClickListener
            }

            //Validasi email tidak sesuai
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.edPassword.error = "Email Tidak Valid"
                binding.edPassword.requestFocus()
                return@setOnClickListener
            }

            //Validasi password
            if (password.isEmpty()){
                binding.edPassword.error = "Password Harus Diisi"
                binding.edPassword.requestFocus()
                return@setOnClickListener
            }

            LoginFirebase(email,password)
        }
    }

    private fun LoginFirebase(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Selamat datang $email", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}