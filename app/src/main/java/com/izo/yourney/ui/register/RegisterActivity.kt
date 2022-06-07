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
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.izo.yourney.R
import com.izo.yourney.databinding.ActivityRegisterBinding
import com.izo.yourney.ui.Users
import com.izo.yourney.ui.chatbot.ChatbotActivity
import com.izo.yourney.ui.customview.PasswordView
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

        binding.btnRegister.setOnClickListener {
            val email = binding.edEmail.text.toString()
            val password = binding.edPassword.text.toString()
            val confirmPassword = binding.edConfirmPassword.text.toString()
            val username = binding.edUsername.text.toString()

            // validasi email
            if (email.isEmpty()){
                binding.edEmail.error = "Email harus diisi"
                binding.edEmail.requestFocus()
                return@setOnClickListener
            }

            when {
                // validasi email
                !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                    binding.edEmail.error = "Email tidak valid"
                    binding.edEmail.requestFocus()
                    return@setOnClickListener
                }
                // validasi password
                password.isEmpty() -> {
                    binding.edPassword.error = "Password harus diisi"
                    binding.edPassword.requestFocus()
                    return@setOnClickListener
                }
                // validasi panjang password
                password.length < 6 -> {
                    binding.edPassword.error = "Password minimal 6 karakter"
                    binding.edPassword.requestFocus()
                    return@setOnClickListener
                }
                // validasi kesamaan text password dan konfirmasi password
                password != confirmPassword -> {
                    binding.edConfirmPassword.error = "Password dan Konfirmasi Password tidak sama"
                    binding.edConfirmPassword.requestFocus()
                    return@setOnClickListener
                }
            }
            RegisterFirebase(email, password, username)
        }

        binding.tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun RegisterFirebase(email: String, password: String, username: String) {


        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener() {
                if (it.isSuccessful) {

                    val intent = Intent(this, PersonaActivity::class.java)
                    val bundle = Bundle()
                    bundle.putString("username", username)
                    bundle.putString("email", email)
                    bundle.putString("password", password)

                    intent.putExtras(bundle)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}

