package com.izo.yourney.ui.persona

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.google.firebase.database.FirebaseDatabase
import com.izo.yourney.R
import com.izo.yourney.databinding.ActivityAboutThreeBinding
import com.izo.yourney.ui.MainActivity
import com.izo.yourney.ui.Users
import com.izo.yourney.ui.login.LoginActivity

class AboutThreeActivity : AppCompatActivity() {


    private lateinit var adapter: RecommendHobbyAdapter
    private lateinit var binding: ActivityAboutThreeBinding
    private lateinit var dream: String
    private lateinit var hobby: String
    private val list = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // rv untuk recommend hobby
        list.addAll(resources.getStringArray(R.array.recommend_hobby))
        showRecyclerView()

        // click events
        clickEvents()
    }

    private fun clickEvents() {
        binding.tvDontHaveHobby.setOnClickListener {
            binding.edHobby.setText(binding.tvDontHaveHobby.text)
        }

        binding.btnNext4.setOnClickListener {
            dream = binding.edDream.text.toString()
            hobby = binding.edHobby.text.toString()
            val bundle = intent.extras
            bundle?.putString("dream", dream)
            bundle?.putString("hobby", hobby)
            Log.d("bundle sekarang di 3 ", bundle.toString())

            //  save ke realtime database
            val ref = FirebaseDatabase.getInstance().getReference("users")
            val usersId = ref.push().key

            //  get Data
            val username = bundle?.getString("username")
            val email = bundle?.getString("email")
            val password = bundle?.getString("password")
            val study = bundle?.getString("study")
            val phone = bundle?.getString("phone")
            val city = bundle?.getString("city")
            val born = bundle?.getString("born")
            val gender = bundle?.getString("gender")

            val inputUser = Users(usersId, username, email, password, city, born, gender, study, phone, dream, hobby)

            if (usersId != null){
                ref.child(usersId).setValue(inputUser).addOnCompleteListener{
                    Toast.makeText(applicationContext,"Data Berhasil ditambahkan", Toast.LENGTH_SHORT).show()
                }
            }
            startActivity(intent)
            finish()
//            showDialog()
        }
    }

//    private fun showDialog() {
//
//        val dialog = Dialog(this)
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//        dialog.setCancelable(true)
//        dialog.setContentView(R.layout.custom_dialog)
//
//
//        val btnOk = dialog.findViewById<Button>(R.id.btn_ok)
//
//        btnOk.setOnClickListener {
//
//            val intent = Intent(this, LoginActivity::class.java)
//            intent.putExtras()
//            startActivity(intent)
//            finish()
//        }
//
////        dialog.show()
//
//    }

    private fun showRecyclerView() {
        adapter = RecommendHobbyAdapter(list)
        binding.rvRecommendHobby.adapter = adapter
        binding.rvRecommendHobby.layoutManager = GridLayoutManager(this, 2)
        adapter.setOnItemClickCallback(object : RecommendHobbyAdapter.OnItemClickCallback{
            override fun onItemClicked(dataRecommend: String) {
                binding.edHobby.setText(dataRecommend)

            }
        })
    }

}