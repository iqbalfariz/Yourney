package com.izo.yourney.ui.persona

import android.app.Dialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.google.firebase.database.FirebaseDatabase
import com.izo.yourney.R
import com.izo.yourney.data.local.StatePreference
import com.izo.yourney.databinding.ActivityAboutThreeBinding
import com.izo.yourney.ui.Users
import com.izo.yourney.ui.ViewModelFactory
import com.izo.yourney.ui.login.LoginActivity
import com.izo.yourney.ui.onboarding.OnBoardingViewModel

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class AboutThreeActivity : AppCompatActivity() {


    private lateinit var adapter: RecommendHobbyAdapter
    private lateinit var binding: ActivityAboutThreeBinding
    private lateinit var dream: String
    private lateinit var hobby: String
    private lateinit var aboutThreeViewModel: AboutThreeViewModel
    private val list = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // set up view model
        setupViewModel()

        // rv untuk recommend hobby
        list.addAll(resources.getStringArray(R.array.recommend_hobby))
        showRecyclerView()

        // click events
        clickEvents()
    }

    private fun setupViewModel() {
        aboutThreeViewModel = ViewModelProvider(
            this,
            ViewModelFactory(StatePreference.getInstance(dataStore))
        )[AboutThreeViewModel::class.java]
    }

    private fun clickEvents() {
        binding.tvDontHaveHobby.setOnClickListener {
            binding.edHobby.setText(binding.tvDontHaveHobby.text)
        }

        binding.radioDream.setOnCheckedChangeListener { radioGroup, id ->
                when (id) {
                    R.id.radio1 -> binding.edDream.setText(binding.radio1.text)
                    R.id.radio2 -> binding.edDream.setText(binding.radio2.text)
                }
        }

        binding.btnNext.setOnClickListener {
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
                    aboutThreeViewModel.saveUsername(username)
                    Toast.makeText(applicationContext,"Data Berhasil ditambahkan", Toast.LENGTH_SHORT).show()
                    showDialog()

                }
            } else {
                Toast.makeText(applicationContext,"Data ada yang belum terisi", Toast.LENGTH_SHORT).show()
            }

        }
    }


    private fun showDialog() {

        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.custom_dialog)


        val btnOk = dialog.findViewById<Button>(R.id.btn_ok)

        btnOk.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
            dialog.dismiss()
        }

        dialog.show()

    }

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