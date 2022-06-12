package com.izo.yourney.ui.chatbot

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.izo.yourney.R
import com.izo.yourney.data.AnswerResponse
import com.izo.yourney.data.remote.ApiConfig
import com.izo.yourney.databinding.ActivityChatbotBinding
import com.izo.yourney.ui.chatbot.Constants.RECEIVE_ID
import com.izo.yourney.ui.chatbot.Constants.SEND_ID
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Response

class ChatbotActivity : AppCompatActivity() {

    private lateinit var adapterMessage: MessageAdapter
    private lateinit var adapterRecommend: RecommendAdapter
    private lateinit var chatbotBinding: ActivityChatbotBinding
    private val list = ArrayList<String>()
    private val timeStamp = Time.timeStamp()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        chatbotBinding = ActivityChatbotBinding.inflate(layoutInflater)
        setContentView(chatbotBinding.root)
        supportActionBar?.title = "Chatbot"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // rv untuk chat
        recyclerViewMessage()

        // rv untuk recommend
        list.addAll(resources.getStringArray(R.array.data_recommend))
        recyclerViewRecommend()

        // jika item di click
        clickEvents()



    }


    private fun clickEvents() {
        chatbotBinding.layoutSend.setOnClickListener {
            val messageEditText = chatbotBinding.edMessage.text.toString()
            sendMessage(messageEditText)
        }

        chatbotBinding.edMessage.setOnClickListener {
            GlobalScope.launch {
                delay(1000)
                withContext(Dispatchers.Main) {
                    chatbotBinding.rvMessage.scrollToPosition(adapterMessage.itemCount - 1)
                }
            }
        }
    }

    private fun recyclerViewMessage() {
        adapterMessage = MessageAdapter()
        chatbotBinding.rvMessage.adapter = adapterMessage
        chatbotBinding.rvMessage.layoutManager = LinearLayoutManager(applicationContext)
    }

    private fun recyclerViewRecommend() {
        adapterRecommend = RecommendAdapter(list)
        chatbotBinding.rvRecommend.adapter = adapterRecommend
        chatbotBinding.rvRecommend.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        adapterRecommend.setOnItemClickCallback(object : RecommendAdapter.OnItemClickCallback{
            override fun onItemClicked(dataRecommend: String) {
                sendMessage(dataRecommend)
            }
        })
    }

    private fun sendMessage(message: String) {
//        val message = chatbotBinding.edMessage.text.toString()

        if (message.isNotEmpty()) {
            chatbotBinding.edMessage.setText("")

            adapterMessage.insertMessage(Message(message, timeStamp,SEND_ID))
            chatbotBinding.rvMessage.scrollToPosition(adapterMessage.itemCount -1)

            botResponse(message)
        }

    }

    private fun botResponse(message: String){

        GlobalScope.launch {
            delay(1000)

            withContext(Dispatchers.Main) {
                val client = ApiConfig.getApiService().postMessage(message)
                client.enqueue(object : retrofit2.Callback<AnswerResponse> {
                    override fun onResponse(
                        call: Call<AnswerResponse>,
                        response: Response<AnswerResponse>
                    ) {
                        val responseBody = response.body()
                        if (response.isSuccessful && responseBody != null) {
                            adapterMessage.insertMessage(Message(responseBody.answer, timeStamp, RECEIVE_ID))
                            chatbotBinding.rvMessage.scrollToPosition(adapterMessage.itemCount - 1)
                        } else {
                            Log.e("ChatbotActivity", "onFailure: ${response.message()}")
                        }
                    }

                    override fun onFailure(call: Call<AnswerResponse>, t: Throwable) {
                        Log.e("ChatbotActivity", "onFailure: ${t.message}")
                    }

                })
            }
        }
    }

    override fun onStart() {
        super.onStart()

        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main) {
                chatbotBinding.rvMessage.scrollToPosition(adapterMessage.itemCount - 1)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}