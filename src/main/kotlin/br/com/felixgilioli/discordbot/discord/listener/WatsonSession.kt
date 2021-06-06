package br.com.felixgilioli.discordbot.discord.listener

import com.ibm.watson.assistant.v2.Assistant

data class WatsonSession(
    val sessionId: String,
    val assistant: Assistant,
    val assistantId: String
)
