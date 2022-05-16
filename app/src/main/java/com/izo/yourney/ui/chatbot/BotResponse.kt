package com.izo.yourney.ui.chatbot

object BotResponse {

    fun basicResponses(_message: String): String {

        val message = _message.toLowerCase()

        return when {

            message.contains("hi") -> "Hi I'm Ney can i help you ?"
            message.contains("i have mental health issues") -> "relax you just need take time"

            else -> "It's error"

        }

    }


}