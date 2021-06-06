package br.com.felixgilioli.discordbot.discord

import br.com.felixgilioli.discordbot.utils.getEnv

val BOT_PREFIX: String by lazy {
    getEnv("BOT_PREFIX")
}
