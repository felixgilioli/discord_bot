package br.com.felixgilioli.discordbot

import br.com.felixgilioli.discordbot.discord.BOT_PREFIX
import br.com.felixgilioli.discordbot.watson.WatsonAPI
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class OnMessageListener : ListenerAdapter() {

    override fun onMessageReceived(event: MessageReceivedEvent) {
        if (event.message.contentRaw.startsWith(BOT_PREFIX)) {
            var message = ""

            if (event.message.contentRaw.length > BOT_PREFIX.length) {
                message = event.message.contentRaw.substring(BOT_PREFIX.length + 1)
            }

            println("Received the message: $message")

            val response = WatsonAPI().getResponse(message)

            println("Sending reply: $response")

            this.sendMessage(event, response)
        }
    }

    private fun sendMessage(event: MessageReceivedEvent, message: String) {
        event.channel.sendMessage(message).queue()
    }
}