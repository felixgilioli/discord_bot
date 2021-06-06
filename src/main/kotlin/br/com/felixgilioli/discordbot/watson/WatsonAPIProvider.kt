package br.com.felixgilioli.discordbot.watson

import br.com.felixgilioli.discordbot.discord.listener.WatsonSession
import br.com.felixgilioli.discordbot.utils.getEnv
import com.ibm.cloud.sdk.core.http.HttpConfigOptions
import com.ibm.cloud.sdk.core.security.IamAuthenticator
import com.ibm.watson.assistant.v2.Assistant
import com.ibm.watson.assistant.v2.model.CreateSessionOptions
import java.time.LocalDate

object WatsonAPIProvider {

    @JvmStatic
    lateinit var session: WatsonSession

    fun login() {
        val assistant = this.getAssistant()

        val assistantId = getEnv("WATSON_ASSISTANT_ID")

        val createSessionOptions = CreateSessionOptions.Builder(assistantId).build()
        val sessionId = assistant.createSession(createSessionOptions).execute().result.sessionId

        val watsonSession = WatsonSession(sessionId, assistant, assistantId)
        this.session = watsonSession
    }

    private fun getAssistant(): Assistant {
        val authenticator = IamAuthenticator(getEnv("WATSON_API_KEY"))

        val version = getEnv("WATSON_ASSISTENT_VERSION") {
            LocalDate.now().toString()
        }

        val assistant = Assistant(version, authenticator)
        assistant.serviceUrl = getEnv("WATSON_URL")

        val configOptions = HttpConfigOptions.Builder().disableSslVerification(true).build()
        assistant.configureClient(configOptions)
        return assistant
    }
}