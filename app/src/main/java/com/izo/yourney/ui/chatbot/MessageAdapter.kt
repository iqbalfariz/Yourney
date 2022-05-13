package com.izo.yourney.ui.chatbot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.transition.Hold
import com.izo.yourney.R
import com.izo.yourney.ui.chatbot.Constants.RECEIVE_ID
import com.izo.yourney.ui.chatbot.Constants.SEND_ID
import java.util.concurrent.RecursiveAction

class MessageAdapter: RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MessageAdapter.MessageViewHolder {
        return MessageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.message_item, parent, false))
    }

    override fun onBindViewHolder(holder: MessageAdapter.MessageViewHolder, position: Int) {
        val currentMessage = messagesList[position]

        when (currentMessage.id) {
            SEND_ID -> {
                holder.tvUser.apply {
                    text = currentMessage.message
                    visibility = View.VISIBLE
                }
                holder.tvBot.visibility = View.GONE
            }
            RECEIVE_ID -> {
                holder.tvBot.apply {
                    text = currentMessage.message
                    visibility = View.VISIBLE
                }
                holder.tvUser.visibility = View.GONE
            }
        }


    }

    override fun getItemCount(): Int = messagesList.size

    fun insertMessage(message: Message) {
        this.messagesList.add(message)
        notifyItemInserted(messagesList.size)
    }

    val messagesList = mutableListOf<Message>()

    inner class MessageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                messagesList.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
            }
        }

        var tvUser = itemView.findViewById<TextView>(R.id.tv_user)
        var tvBot = itemView.findViewById<TextView>(R.id.tv_chatbot)




    }

}