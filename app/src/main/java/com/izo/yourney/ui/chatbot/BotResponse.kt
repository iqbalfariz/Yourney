package com.izo.yourney.ui.chatbot

import okhttp3.RequestBody
import retrofit2.Retrofit
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PartMap


//ini coba api nlp


object BotResponse {


    fun basicResponses(_message: String): String {
        val URL = "https://nlp-model-yourney-lslrhnaybq-et.a.run.app/predict"
        val mRetrofit: Retrofit? = null

        val message = _message.toLowerCase()

//        try {
//            val fileBody: RequestBody =
//                RequestBody.create(MediaType.parse("multipart/form-data"), photo)
//            map["image\"; filename=\"" + photo.getName().toString() + "\""] = fileBody
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }


        return when {

            message.contains("hi") -> "Hi I'm Ney can i help you ?"
            message.contains("i have mental health issues") -> "relax you just need take time"


            else -> "It's error"

        }

    }





}