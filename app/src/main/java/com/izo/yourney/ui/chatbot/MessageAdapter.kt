package com.izo.yourney.ui.chatbot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.izo.yourney.R
import com.izo.yourney.ui.chatbot.Constants.SEND_ID

class MessageAdapter(): Adapter<ViewHolder>(){

    private val ITEM_USER = 1
    private val ITEM_BOT = 2
    private val messagesList = mutableListOf<Message>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        if (viewType == 1) {
            // inflate item user message
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_container_user_message, parent, false)
            return UserViewHolder(view)
        } else {
            // inflate item bot message
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_container_bot_message, parent, false)
            return BotViewHolder(view)
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentMessage = messagesList[position]

        if (holder.javaClass == UserViewHolder::class.java) {
            // untuk message user

            val viewHolder = holder as UserViewHolder
            holder.tvUserMessage.text = currentMessage.message
        } else {
            // untuk bot message

            val viewHolder = holder as BotViewHolder
            holder.tvBotMessage.text = currentMessage.message
        }
    }

    override fun getItemCount(): Int = messagesList.size

    override fun getItemViewType(position: Int): Int {
        val currentMessage = messagesList[position]

        return if (currentMessage.id == SEND_ID) {
            ITEM_USER
        } else {
            ITEM_BOT
        }
    }

    fun insertMessage(message: Message) {
        this.messagesList.add(message)
        notifyItemInserted(messagesList.size)
    }

    class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvUserMessage = itemView.findViewById<TextView>(R.id.tv_user_message)
    }

    class BotViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvBotMessage = itemView.findViewById<TextView>(R.id.tv_bot_message)
    }

}