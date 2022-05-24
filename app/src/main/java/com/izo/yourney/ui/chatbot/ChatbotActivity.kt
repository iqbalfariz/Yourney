package com.izo.yourney.ui.chatbot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.izo.yourney.R
import com.izo.yourney.databinding.ActivityChatbotBinding
import com.izo.yourney.ui.chatbot.Constants.RECEIVE_ID
import com.izo.yourney.ui.chatbot.Constants.SEND_ID
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

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
            sendMessage()
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
                chatbotBinding.edMessage.setText(dataRecommend)
            }
        })
    }

    private fun sendMessage() {
        val message = chatbotBinding.edMessage.text.toString()

        if (message.isNotEmpty()) {
            chatbotBinding.edMessage.setText("")

            adapterMessage.insertMessage(Message(message, timeStamp,SEND_ID))
            chatbotBinding.rvMessage.scrollToPosition(adapterMessage.itemCount - 1)

            botResponse(message)
        }

    }

    private fun botResponse(message: String){

        GlobalScope.launch {
            delay(1000)

            withContext(Dispatchers.Main) {
                val response = BotResponse.basicResponses(message)
                adapterMessage.insertMessage(Message(response, timeStamp, RECEIVE_ID))
                chatbotBinding.rvMessage.scrollToPosition(adapterMessage.itemCount - 1)
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