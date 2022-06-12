package com.izo.yourney.ui.chatbot

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.izo.yourney.data.AnswerResponse
import com.izo.yourney.data.remote.ApiConfig
import retrofit2.Call
import retrofit2.Response

class ChatbotViewModel: ViewModel() {

    private val _answer = MutableLiveData<String>()
    val answer: LiveData<String> = _answer

    fun postMessage(message: String){
        val client = ApiConfig.getApiService().postMessage(message)
        client.enqueue(object : retrofit2.Callback<AnswerResponse> {
            override fun onResponse(
                call: Call<AnswerResponse>,
                response: Response<AnswerResponse>
            ) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    _answer.value = responseBody.answer
                } else {
                    Log.e("ChatbotActivity", "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<AnswerResponse>, t: Throwable) {
                Log.e("ChatbotActivity", "onFailure: ${t.message}")
            }

        })

    }

    companion object {
        private const val TAG = "ChatbotViewModel"
    }

}