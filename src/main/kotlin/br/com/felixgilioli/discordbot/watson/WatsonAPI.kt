package br.com.felixgilioli.discordbot.watson

import com.ibm.cloud.sdk.core.service.exception.NotFoundException
import com.ibm.watson.assistant.v2.model.MessageInput
import com.ibm.watson.assistant.v2.model.MessageOptions

class WatsonAPI {

    fun getResponse(message: String?): String {
        val session = WatsonAPIProvider.session

        val messageOptions = MessageOptions.Builder(session.assistantId, session.sessionId)
            .input(if (message.isNullOrBlank()) null else this.getMessageInput(message))
            .build()

        return try {
            val response = session.assistant.message(messageOptions).execute().result
            response.output.generic.joinToString(separator = "\n") { it.text() }
        } catch (e: NotFoundException) {
            WatsonAPIProvider.login()
            getResponse(message)
        }
    }

    private fun getMessageInput(message: String): MessageInput {
        return MessageInput.Builder()
            .messageType("text")
            .text(message)
            .build()
    }

}