package com.izo.yourney.ui.register

//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.util.Patterns
//import android.widget.*
//import com.google.firebase.auth.FirebaseAuth
//import com.izo.yourney.databinding.ActivityRegisterBinding
//import com.izo.yourney.ui.login.LoginActivity
//import com.izo.yourney.ui.persona.PersonaActivity

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
//import android.widget.Toast
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.izo.yourney.databinding.ActivityRegisterBinding
import com.izo.yourney.ui.login.LoginActivity
import com.izo.yourney.ui.persona.PersonaActivity


//class RegisterActivity : AppCompatActivity() {
//
//
//    lateinit var auth : FirebaseAuth
//
//    private lateinit var binding: ActivityRegisterBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityRegisterBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//
//        binding.btnRegis.setOnClickListener {
//            val intent = Intent(this, PersonaActivity::class.java)
//            startActivity(intent)
//            finish()
//        }
//
//        binding.tvLogin.setOnClickListener {
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//            finish()
//        }
//    }
//}

// punya yusuf
class RegisterActivity : AppCompatActivity() {


    lateinit var auth : FirebaseAuth
    lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.btnRegis.setOnClickListener {
            val email = binding.edEmail.text.toString()
            val password = binding.edPassword.text.toString()
            val username = binding.edUsername.text.toString()

            // validasi email
            if (email.isEmpty()){
                binding.edEmail.error = "Email Harus Diisi"
                binding.edEmail.requestFocus()
                return@setOnClickListener
            }

            // validasi email tidak sesuai
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.edEmail.error = "Email Tidak Valid"
                binding.edEmail.requestFocus()
                return@setOnClickListener
            }

            // validasi password
            if (password.isEmpty()){
                binding.edPassword.error = "Password Harus Diisi"
                binding.edPassword.requestFocus()
                return@setOnClickListener
            }

            // validasi panjang password
            if(password.length <= 6) {
                binding.edPassword.error = "Password Minimal 6 Character"
                binding.edPassword.requestFocus()
                return@setOnClickListener
            }

            RegisterFirebase(email, password)
        }

        binding.tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun RegisterFirebase(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Register Berhasil", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}


