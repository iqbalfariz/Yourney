package com.izo.yourney.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.firebase.database.FirebaseDatabase
import com.izo.yourney.R
import com.izo.yourney.ui.chatbot.ChatbotActivity
import com.izo.yourney.ui.counseling.CounselingActivity
import com.izo.yourney.ui.customview.PasswordView

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnChatbot = findViewById<Button>(R.id.btn_chatbot)
        btn.setOnClickListener {
            val intent = Intent(this, ChatbotActivity::class.java)
            startActivity(intent)
        }

        val btnCounseling = findViewById<Button>(R.id.btn_counseling)
        btnCounseling.setOnClickListener {
            val intent = Intent(this, CounselingActivity::class.java)
            startActivity(intent)
        }

        // regist
        name = findViewById(R.id.ed_username)
        email = findViewById(R.id.ed_email)
        pasword = findViewById(R.id.ed_password)
        confirmPass = findViewById(R.id.ed_confirm_password)
        subRegits1 = findViewById(R.id.btn_regis)

        subRegits1.setOnClickListener(this)

        city = findViewById(R.id.ed_city)
        bornDate = findViewById(R.id.born_date)
        genderMale = findViewById(R.id.tv_male)
        genderFemale = findViewById(R.id.tv_female)
        subRegist2 = findViewById(R.id.btn_next2)

        subRegist2.setOnClickListener(this)

        studySMA = findViewById(R.id.tv_sma)
        studyKuliah = findViewById(R.id.tv_collage)
        studyLulus = findViewById(R.id.tv_lulus)
        studyTdkLulus = findViewById(R.id.tv_putus)
        phoneNumber = findViewById(R.id.ed_phone_number)
        subRegist3 = findViewById(R.id.btn_next3)

        subRegist3.setOnClickListener(this)

        dream  = findViewById(R.id.ed_dream)
        dreamTemp = findViewById(R.id.radio_dream)
        hobby = findViewById(R.id.ed_hobby)
        subRegist4 = findViewById(R.id.btn_next4)

        subRegist4.setOnClickListener(this)

//        val gender = ""
//
//        if (genderMale != null) {
//            Toast.makeText(applicationContext,"Tombol laki dipencet", Toast.LENGTH_SHORT).show()
//        }

    }

    override fun onClick(v: View?) {
        saveData()
    }

    private fun saveData() {
        // wajib isi
        val textName = name.text.toString().trim()
        val textEmail = email.text.toString().trim()
        val textPass = pasword.text.toString().trim()
        val textConfirmPass = confirmPass.text.toString().trim()

        if (textName.isEmpty()){
            name.error = "Name is empty"
            return
        }

        if (textEmail.isEmpty()){
            email.error = "Email is empty"
            return
        }

        if (textPass.isEmpty()) {
            pasword.error = "Password is empty"
            return
        }

        if (textConfirmPass.isEmpty()){
            confirmPass.error = "Confirm Password is empty"
            return
        }

        if (textPass != textConfirmPass){
            Toast.makeText(applicationContext,"Password dan Konfirmasi Password tidak sama", Toast.LENGTH_SHORT).show()
        }

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

    }
    // testing
}