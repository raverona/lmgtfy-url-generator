package br.com.raverona.lmgtfy.provider

import br.com.raverona.lmgtfy.searchType.SearchType
import java.lang.RuntimeException

abstract class Provider {
    val queryStringKey = 's'
    abstract val queryStringValue: Char
    abstract val availableSearchTypes: List<SearchType>

    companion object {

        fun getByName(name: String): Provider {
            return when (name) {
                "google" -> Google
                "bing" -> Bing
                "yahoo" -> Yahoo
                "aol" -> Aol
                "ask" -> Ask
                "duckduckgo" -> Duckduckgo
                else -> throw InvalidProvider(name)
            }
        }
    }
}

class InvalidProvider(providerName: String): RuntimeException("Invalid provider: $providerName")
class UnsupportedSearchType(providerName: String, searchTypeName: String): RuntimeException("Provider $providerName does not support $searchTypeName search")
