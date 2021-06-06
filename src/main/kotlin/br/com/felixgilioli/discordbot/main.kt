package br.com.felixgilioli.discordbot

import br.com.felixgilioli.discordbot.utils.getEnv
import br.com.felixgilioli.discordbot.watson.WatsonAPIProvider
import net.dv8tion.jda.api.JDABuilder

fun main() {
    WatsonAPIProvider.login()
    val botToken = getEnv("BOT_TOKEN")

    val jda = JDABuilder.createDefault(botToken).build()
    jda.addEventListener(OnMessageListener())
    println("Application started.")
}
