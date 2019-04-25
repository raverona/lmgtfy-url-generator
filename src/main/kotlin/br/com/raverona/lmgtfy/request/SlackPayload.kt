package br.com.raverona.lmgtfy.request

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class SlackPayload(val text: String, val command: String) {
    val providerName: String

    init {
        providerName = command.removePrefix("/")
    }
}