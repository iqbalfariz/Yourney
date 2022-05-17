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

    private lateinit var adapter: MessageAdapter
    private lateinit var chatbotBinding: ActivityChatbotBinding
    private val timeStamp = Time.timeStamp()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        chatbotBinding = ActivityChatbotBinding.inflate(layoutInflater)
        setContentView(chatbotBinding.root)
        supportActionBar?.title = "Chatbot"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerView()

        clickItems()

    }

    private fun clickItems() {
        chatbotBinding.layoutSend.setOnClickListener {
            sendMessage()
        }

        chatbotBinding.edMessage.setOnClickListener {
            GlobalScope.launch {
                delay(1000)
                withContext(Dispatchers.Main) {
                    chatbotBinding.rvMessage.scrollToPosition(adapter.itemCount - 1)
                }
            }
        }
    }

    private fun recyclerView() {
        adapter = MessageAdapter()
        chatbotBinding.rvMessage.adapter = adapter
        chatbotBinding.rvMessage.layoutManager = LinearLayoutManager(applicationContext)
    }

    private fun sendMessage() {
        val message = chatbotBinding.edMessage.text.toString()

        if (message.isNotEmpty()) {
            chatbotBinding.edMessage.setText("")

            adapter.insertMessage(Message(message, timeStamp,SEND_ID))
            chatbotBinding.rvMessage.scrollToPosition(adapter.itemCount - 1)

            botResponse(message)
        }

    }

    private fun botResponse(message: String){

        GlobalScope.launch {
            delay(1000)

            withContext(Dispatchers.Main) {
                val response = BotResponse.basicResponses(message)
                adapter.insertMessage(Message(response, timeStamp, RECEIVE_ID))
                chatbotBinding.rvMessage.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }

    override fun onStart() {
        super.onStart()

        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main) {
                chatbotBinding.rvMessage.scrollToPosition(adapter.itemCount - 1)
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