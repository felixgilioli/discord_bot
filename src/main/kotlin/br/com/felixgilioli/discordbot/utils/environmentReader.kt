package br.com.felixgilioli.discordbot.utils

fun getEnv(envName: String) = System.getenv(envName)
    ?: throw RuntimeException("Could not find environment variable: $envName")

fun getEnv(envName: String, defaultValue: () -> String) : String {
    return System.getenv(envName) ?: defaultValue.invoke()
}