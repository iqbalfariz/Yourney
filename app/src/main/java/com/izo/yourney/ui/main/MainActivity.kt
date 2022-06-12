package com.izo.yourney.ui.main

import android.app.Dialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.*
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.izo.yourney.R
import com.izo.yourney.data.local.StatePreference
import com.izo.yourney.databinding.ActivityMainBinding
import com.izo.yourney.ui.ViewModelFactory
import com.izo.yourney.ui.chatbot.ChatbotActivity
import com.izo.yourney.ui.counseling.intro.IntroCounselingActivity
import com.izo.yourney.ui.customview.PasswordView
import com.izo.yourney.ui.fragments.*
import com.izo.yourney.ui.launchscreen.LaunchScreenActivity
import com.izo.yourney.ui.login.LoginActivity
import com.izo.yourney.ui.onboarding.OnBoardingActivity
import com.izo.yourney.ui.splashscreen.SplashScreenViewModel


private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // page 1 regist
    private lateinit var name : EditText
    private lateinit var email : EditText
    private lateinit var pasword : PasswordView
    private lateinit var confirmPass : PasswordView
    private lateinit var subRegits1 : Button

    // page 2 regist
    private lateinit var city : EditText
    private lateinit var bornDate : DatePicker
    private lateinit var genderMale : TextView
    private lateinit var genderFemale : TextView
    private lateinit var subRegist2 : Button

    // page 3 regist
    private lateinit var studySMA : TextView
    private lateinit var studyKuliah : TextView
    private lateinit var studyLulus : TextView
    private lateinit var studyTdkLulus : TextView
    private lateinit var phoneNumber : EditText
    private lateinit var subRegist3 : Button

    // page 4 regits
    private lateinit var dream : EditText
    private lateinit var dreamTemp : RadioGroup
    private lateinit var hobby : EditText
    private lateinit var subRegist4 : Button

    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    private lateinit var bottomNavView : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setupViewModel()
//        clickEvents()

        supportActionBar?.hide()
        bottomNavView = binding.BottomNavigationView

        val homeFragment = HomeFragment()
        val jelajahFragment = JelajahFragment()
        val iconFragment = IconFragment()
        val jadwalFragment = JadwalFragment()
        val profileFragment = ProfileFragment()

        setThatFragment(homeFragment)

        bottomNavView.setOnItemReselectedListener {
            when (it.itemId) {
                R.id.beranda ->{
                    setThatFragment(homeFragment)
                }
                R.id.jelajah ->{
                    setThatFragment(jelajahFragment)
                }
                R.id.icon ->{
                    setThatFragment(iconFragment)
                }
                R.id.jadwal ->{
                    setThatFragment(jadwalFragment)
                }
                R.id.profile ->{
                    setThatFragment(profileFragment)
                }
            }
            true
        }

    }

    private fun setThatFragment(fragment : Fragment)  =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame,fragment)
            commit()
        }


    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

}

//    private fun setupViewModel() {
//        mainViewModel = ViewModelProvider(
//            this,
//            ViewModelFactory(StatePreference.getInstance(dataStore))
//        )[MainViewModel::class.java]
//    }

//    private fun clickEvents() {

//        // go to chatbot
//        binding.btnChatbot.setOnClickListener {
//            val intentToChatbot = Intent(this, ChatbotActivity::class.java)
//            startActivity(intentToChatbot)
//        }
//
//        // go to counseling
//        binding.btnCounseling.setOnClickListener {
//            val intentToCounseling = Intent(this, IntroCounselingActivity::class.java)
//            startActivity(intentToCounseling)
//        }
//
//        // logout
//        binding.btnLogout.setOnClickListener {
////            mainViewModel.logout()
////            val intentLogout = Intent(this, OnBoardingActivity::class.java)
////            startActivity(intentLogout)
////            finish()
//            showDialog()
//        }
//
//    }

//    private fun showDialog() {
//        val dialog = Dialog(this)
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//        dialog.setCancelable(false)
//        dialog.setContentView(R.layout.custom_dialog_logout)
//
//
//        val btnYes = dialog.findViewById<Button>(R.id.btn_yes)
//        val btnNo = dialog.findViewById<Button>(R.id.btn_no)
//
//        btnYes.setOnClickListener {
//            mainViewModel.logout()
//            val intentLogout = Intent(this, LaunchScreenActivity::class.java)
//            startActivity(intentLogout)
//            finish()
//            dialog.dismiss()
//        }
//
//        btnNo.setOnClickListener {
//            dialog.dismiss()
//        }
//
//        dialog.show()
//    }
//
//    override fun onClick(v: View?) {
//        saveData()
//    }
//
//    private fun saveData() {
//        // wajib isi
//        val textName = name.text.toString().trim()
//        val textEmail = email.text.toString().trim()
//        val textPass = pasword.text.toString().trim()
//        val textConfirmPass = confirmPass.text.toString().trim()
//
//        if (textName.isEmpty()){
//            name.error = "Name is empty"
//            return
//        }
//
//        if (textEmail.isEmpty()){
//            email.error = "Email is empty"
//            return
//        }
//
//
//        if (textPass.isEmpty()) {
//            pasword.error = "Password is empty"
//            return
//        }
//
//        if (textConfirmPass.isEmpty()){
//            confirmPass.error = "Confirm Password is empty"
//            return
//        }
//
//        if (textPass != textConfirmPass){
//            Toast.makeText(applicationContext,"Password dan Konfirmasi Password tidak sama", Toast.LENGTH_SHORT).show()
//        }

        // tidak wajib isi
//        val textcity = city.text.toString().trim()
//        val textBornDate = bornDate.dayOfMonth.toString().trim()
//        val textGenderMale = genderMale.text.toString().trim()
//        val textGenderFemale = genderFemale.text.toString().trim()
//
//
//        val textStudySMA = studySMA.text.toString().trim()
//        val textKuliah = studyKuliah.text.toString().trim()
//        val textLulus = studyLulus.text.toString().trim()
//        val textTdkLulus = studyTdkLulus.text.toString().trim()
//        val textPhoneNumber = phoneNumber.text.toString().trim()
//
//        val textDream = dream.text.toString().trim()
//        val textDreamTemp = dreamTemp.checkedRadioButtonId.toString().trim()
//        val textHobby = hobby.text.toString().trim()
//
//        val ref = FirebaseDatabase.getInstance().getReference("users")
//
//        val usersId = ref.push().key
//
//        val inputUser = Users(usersId, textName, textEmail, textPass, textcity, textBornDate, textGenderMale, textStudySMA, textPhoneNumber, textDream, textHobby)
//
//        if (usersId != null){
//            ref.child(usersId).setValue(inputUser).addOnCompleteListener{
//                Toast.makeText(applicationContext,"Data Berhasil ditambahkan", Toast.LENGTH_SHORT).show()
//            }
//        }

//    }
//    // testing
//}