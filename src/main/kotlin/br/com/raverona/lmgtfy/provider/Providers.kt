package br.com.raverona.lmgtfy.provider

import java.lang.RuntimeException

enum class Providers(val queryStringValue: String) {
    GOOGLE("g"),
    BING("b"),
    YAHOO("y"),
    AOL("a"),
    ASK("k"),
    DUCKDUCKGO("d");

    val queryStringKey = "s"

}

fun getProvider(providerName: String): Providers {
    try {
        return Providers.valueOf(providerName.toUpperCase())
    } catch (illegalArgumentException: IllegalArgumentException) {
        throw InvalidProvider(providerName)
    }
}

class InvalidProvider(val provider: String): RuntimeException("Invalid searchType: $provider")